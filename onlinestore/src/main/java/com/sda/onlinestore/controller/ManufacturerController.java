package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.ManufacturerDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.service.ManufacturerService;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;


    @PostMapping("/addManufacturer")
    @PreAuthorize("hasRole('ADMIN')")
    public void addProduct(@RequestBody ManufacturerDto manufacturerDto){
        manufacturerService.addManufacturer(manufacturerDto);
    }


    @GetMapping("/getManufacturers")
    public List<ManufacturerDto> getManufacturers(){
        return manufacturerService.getManufacturers();
    }


    @GetMapping("/getManufacturerById/{id}")
    public ManufacturerDto findByID(@PathVariable(name = "id") Long id){
        return manufacturerService.findManufacturerById(id);
    }


    @DeleteMapping("/deleteManufacturer/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteManufacturer(@PathVariable(name = "id") Long id){
        manufacturerService.deleteProduct(id);
    }

    @PutMapping("/updateManufacturer")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
        manufacturerService.updateManufacturer(manufacturerDto);
    }
}
