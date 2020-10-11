package com.sda.onlinestore.dto;

import com.sda.onlinestore.model.CategoryModel;
import com.sda.onlinestore.model.ManufacturerModel;

public class ProductDto {

    private Long id;
    private String name;
    private ManufacturerDto manufacturerDto;



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
