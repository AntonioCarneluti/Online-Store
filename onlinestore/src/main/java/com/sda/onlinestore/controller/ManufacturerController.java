package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.ManufacturerDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.service.ManufacturerService;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;


    @PostMapping("/addManufacturer")
    public void addProduct(@RequestBody ManufacturerDto manufacturerDto){
        manufacturerService.addManufacturer(manufacturerDto);
    }


    @GetMapping("/getManufacturers")
    public List<ManufacturerDto> getManufacturers(){
        return manufacturerService.getManufacturers();
    }


    @GetMapping("/getById/{id}")
    public ManufacturerDto findByID(@PathVariable(name = "id") Long id){
        return manufacturerService.findManufacturerById(id);
    }


    @DeleteMapping("/manufacturers/{id}")
    public void deleteManufacturer(@PathVariable(name = "id") Long id){
        manufacturerService.deleteProduct(id);
    }

    @PutMapping("/updateManufacturer")
    public void updateManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
        ManufacturerDto updatedManufacturer = manufacturerService.findManufacturerById(manufacturerDto.getId());
        updatedManufacturer.setName(manufacturerDto.getName());
        manufacturerService.addManufacturer(updatedManufacturer);
    }
}
