package com.app.orderline;

import com.app.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrdreLineMapper {
//    var order = mapper.toOrderLine(orderLineRequest);

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .quantity(orderLineRequest.quantity())
                .order(
                        Order.builder().id(orderLineRequest.orderId()).build()
                )
                .productId(orderLineRequest.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
