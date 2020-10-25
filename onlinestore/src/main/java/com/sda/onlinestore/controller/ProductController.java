package com.sda.onlinestore.controller;


import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.model.ProductModel;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/addProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }


    @GetMapping("/getProducts")
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }


    @GetMapping("/getProductById/{id}")
    public ProductDto findByID(@PathVariable(name = "id") Long id){
       return productService.findProductById(id);
    }


    @DeleteMapping("/deleteProduct/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateProduct(@RequestBody ProductDto productDto) {
       productService.updateProduct(productDto);
    }
}
