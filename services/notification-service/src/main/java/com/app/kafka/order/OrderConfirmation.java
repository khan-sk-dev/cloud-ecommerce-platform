package com.app.kafka.order;

import com.app.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totoalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
