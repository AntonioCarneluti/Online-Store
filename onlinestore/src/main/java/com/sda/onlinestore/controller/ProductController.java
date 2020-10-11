package com.sda.onlinestore.controller;


import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.model.ProductModel;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
    }


    @GetMapping("/getProducts")
    public List<ProductDto> getProducts(){
        return productService.getProducts();
    }


    @GetMapping("/getById/{id}")
    public ProductDto findByID(@PathVariable(name = "id") Long id){
       return productService.findProductById(id);
    }


    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProducts")
    public void updateProduct(@RequestBody ProductDto productDto) {
        ProductDto updatedProduct = productService.findProductById(productDto.getId());
        updatedProduct.setName(productDto.getName());
        productService.addProduct(updatedProduct);
    }
}
