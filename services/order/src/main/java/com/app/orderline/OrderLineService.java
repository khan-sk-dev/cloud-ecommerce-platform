package com.app.orderline;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrdreLineMapper ordreLineMapper;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = ordreLineMapper.toOrderLine(orderLineRequest);
        return orderLineRepository.save(order).getId();
    }
}
