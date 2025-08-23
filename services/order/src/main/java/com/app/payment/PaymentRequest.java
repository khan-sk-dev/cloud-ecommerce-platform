package com.app.payment;

import com.app.customer.CustomerResponse;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        com.app.order.@jakarta.validation.constraints.NotEmpty(message = "Payment method should be precised") PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customerResponse
) {
}
