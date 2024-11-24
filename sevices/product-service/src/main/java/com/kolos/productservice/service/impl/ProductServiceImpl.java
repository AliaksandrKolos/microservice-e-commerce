package com.kolos.productservice.service.impl;

import com.kolos.productservice.data.repository.ProductRepository;
import com.kolos.productservice.service.ProductMapper;
import com.kolos.productservice.service.ProductService;
import com.kolos.productservice.service.dto.ProductPurchaseRequest;
import com.kolos.productservice.service.dto.ProductPurchaseResponse;
import com.kolos.productservice.service.dto.ProductRequest;
import com.kolos.productservice.service.dto.ProductResponse;
import com.kolos.productservice.service.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Integer createProduct(ProductRequest request) {
        var product = productMapper.toProduct(request);
        return productRepository.save(product).getId();
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productsIds = request.stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productsIds);
        if (productsIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();
        var purchaseProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.getQuantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.getProductId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchaseProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.getQuantity()));
        }
        return purchaseProducts;
    }

    @Override
    public ProductResponse findById(Integer productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " +  productId));
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
