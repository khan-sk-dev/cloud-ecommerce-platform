package com.app.order;

import brave.Response;
import com.app.customer.CustomerClient;
import com.app.exception.BuisnessException;
import com.app.kafka.OrderConfirmation;
import com.app.kafka.OrderProducer;
import com.app.orderline.OrderLineRequest;
import com.app.orderline.OrderLineService;
import com.app.product.ProductClient;
import com.app.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;


    public Integer createdOrder(OrderRequest request) {
        //check the customer OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId()).orElseThrow(() -> new BuisnessException("Cannot create order:: No Customer exists with provided ID"));

        //purschasae the products --> products-ms(REST-Template)
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //persist-order
        var order = this.orderRepository.save(orderMapper.toOrder(request));

        //persist order-lines
        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // ToDo start payment-process
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.refrence(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        //send the order confirmation --> notificartion-ms(kafka)
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::fromOrder).collect(Collectors.toList());
    }


    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with provided ID: %d", orderId)));
    }


}
