package com.anand.productservice.service;

import com.anand.productservice.entity.Product;
import com.anand.productservice.exception.ProductServiceCustomException;
import com.anand.productservice.model.ProductRequest;
import com.anand.productservice.model.ProductResponse;
import com.anand.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productReposiory;
    @Override
    public long addProduct(ProductRequest productRequest) {
       log.info("Adding Product ....");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .productPrice(productRequest.getProductPrice()).build();

        productReposiory.save(product);
        log.info("Product Created ...");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get the product for product service:"+productId);
        Product product = productReposiory.findById(productId)
                .orElseThrow(()-> new ProductServiceCustomException("Product with given Id not found","PRODUCT_ID_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product,productResponse);

        return productResponse;
    }
}
