package com.anand.productservice.service;

import com.anand.productservice.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
}
