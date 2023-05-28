package com.anand.productservice.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ProductRequest {

    private String name;
    private double productPrice;
    private int quantity;

}
