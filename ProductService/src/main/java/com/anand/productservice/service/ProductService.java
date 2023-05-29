package com.anand.productservice.service;

import com.anand.productservice.model.ProductRequest;
import com.anand.productservice.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
