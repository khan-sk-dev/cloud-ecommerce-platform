package com.app.order;

import com.app.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderRequest(

        Integer id,
        String refrence,
        @Positive(message = "Order amount should be positive")
        BigDecimal amount,
        @NotEmpty(message = "Payment method should be precised")
        PaymentMethod paymentMethod,
        @NotBlank(message = "Customer should be present")
        String customerId,
        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequest> products
) {
}
