package com.app.kafka;

import com.app.customer.CustomerResponse;
import com.app.order.PaymentMethod;
import com.app.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderRefrence,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customerResponse,
        List<PurchaseResponse> products
) {
}
