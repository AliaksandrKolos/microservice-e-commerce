package com.kolos.productservice.service;

import com.kolos.productservice.service.dto.ProductPurchaseRequest;
import com.kolos.productservice.service.dto.ProductPurchaseResponse;
import com.kolos.productservice.service.dto.ProductRequest;
import com.kolos.productservice.service.dto.ProductResponse;

import java.util.List;

public interface ProductService
{
    Integer createProduct(ProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

    ProductResponse findById(Integer productId);

    List<ProductResponse> findAll();
}
