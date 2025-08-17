package com.app.order;

import com.app.customer.CustomerClient;
import com.app.exception.BuisnessException;
import com.app.kafka.OrderConfirmation;
import com.app.kafka.OrderProducer;
import com.app.orderline.OrderLineRequest;
import com.app.orderline.OrderLineService;
import com.app.product.ProductClient;
import com.app.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
