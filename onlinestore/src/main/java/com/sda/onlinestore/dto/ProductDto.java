package com.sda.onlinestore.dto;

import com.sda.onlinestore.model.CategoryModel;
import com.sda.onlinestore.model.ManufacturerModel;

public class ProductDto {

    private Long id;
    private String name;
    private double price;
    private ManufacturerDto manufacturerDto;
    private CategoryDto categoryDto;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public ManufacturerDto getManufacturerDto() {
        return manufacturerDto;
    }

    public void setManufacturerDto(ManufacturerDto manufacturerDto) {
        this.manufacturerDto = manufacturerDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
