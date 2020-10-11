package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.ManufacturerDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.model.ManufacturerModel;
import com.sda.onlinestore.model.ProductModel;
import com.sda.onlinestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getProducts()

    {
        List<ProductModel> productModelList = new ArrayList<>();
        List<ProductDto> productDtoList = new ArrayList<>();

        for (ProductModel productModel : productModelList) {
            ProductDto productDto = new ProductDto();
            productDto.setName(productModel.getName());


            ManufacturerDto manufacturerDto = new ManufacturerDto();
            ManufacturerModel manufacturerModel = productModel.getManufacturerModel();
            manufacturerDto.setName(manufacturerModel.getName());



            productDto.setManufacturerDto(manufacturerDto);

            productDtoList.add(productDto);

        }
        return productDtoList;
    }
    public ProductDto findProductById(Long id){
        Optional<ProductModel> optionalProductModel = productRepository.findById(id);
        if (optionalProductModel.isPresent()) {
            ProductModel productModel = optionalProductModel.get();
            ProductDto productDto = new ProductDto();
            productDto.setName(productModel.getName());


            ManufacturerDto manufacturerDto = new ManufacturerDto();
            ManufacturerModel manufacturerModel = productModel.getManufacturerModel();
            manufacturerDto.setName(manufacturerModel.getName());



            productDto.setManufacturerDto(manufacturerDto);

            return productDto;
        }
            return null;
    }

    public void addProduct(ProductDto productDto){
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productRepository.save(productModel);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public void updateProduct(ProductDto productDto){
        Optional<ProductModel> optionalProductModel = productRepository.findById(productDto.getId());
        if(optionalProductModel.isPresent()){
           ProductModel productModel =  optionalProductModel.get();
            productModel.setName(productDto.getName());
            productRepository.save(productModel);

        }
    }

}
