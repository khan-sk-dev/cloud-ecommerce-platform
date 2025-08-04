package com.app.product;

import com.app.product.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProdcutService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer createProduct(ProductRequest request) {
        var product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> productPurchaseRequest) {
        var productIds = productPurchaseRequest.stream().map(ProductPurchaseRequest::productId).toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exists");
        }

        var storesRequest = productPurchaseRequest.stream().sorted(Comparator.comparing(ProductPurchaseRequest::productId)).toList();
        var purchasedProduct = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storesRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID::" + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProduct.add(productMapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProduct;
    }

    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId).map(productMapper::toProductResponse).orElseThrow(() -> new EntityNotFoundException("Product not found with the ID::" + productId));

    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }
}
