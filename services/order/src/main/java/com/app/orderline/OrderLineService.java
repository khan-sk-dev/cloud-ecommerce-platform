package com.app.orderline;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrdreLineMapper ordreLineMapper;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = ordreLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(ordreLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
