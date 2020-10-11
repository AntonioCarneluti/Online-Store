package com.sda.onlinestore.dto;

import com.sda.onlinestore.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerDto {
    private Long id;
    private String name;
    private List<ProductDto> productDtoList = new ArrayList();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public void setProductDtoList(List<ProductDto> productDtoList) {
        this.productDtoList = productDtoList;
    }
}
