package com.app.product;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductCotroller {


    private final ProdcutService prodcutService;

    
    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(prodcutService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProduct(@RequestBody List<ProductPurchaseRequest> productPurchaseRequest) {
        return ResponseEntity.ok(prodcutService.purchaseProducts(productPurchaseRequest));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable("product-id") Integer productId) {
        return ResponseEntity.ok(prodcutService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(prodcutService.findAll());
    }

}
