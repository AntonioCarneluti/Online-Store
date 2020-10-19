package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.CategoryDto;
import com.sda.onlinestore.dto.ManufacturerDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.model.CategoryModel;
import com.sda.onlinestore.model.ManufacturerModel;
import com.sda.onlinestore.model.ProductModel;
import com.sda.onlinestore.repository.CategoryRepository;
import com.sda.onlinestore.repository.ManufacturerRepository;
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

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductDto> getProducts() {
        List<ProductModel> productModelList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();

        for (ProductModel productModel : productModelList) {
            ProductDto productDto = new ProductDto();
            productDto.setId(productModel.getId());
            productDto.setName(productModel.getName());
            productDto.setPrice(productModel.getPrice());


            if (productModel.getManufacturerModel() != null) {
                ManufacturerDto manufacturerDto = new ManufacturerDto();
                ManufacturerModel manufacturerModel = productModel.getManufacturerModel();
                manufacturerDto.setId(manufacturerModel.getId());
                manufacturerDto.setName(manufacturerModel.getName());
                productDto.setManufacturerDto(manufacturerDto);
            }
            if (productModel.getCategoryModel() != null) {
                CategoryDto categoryDto = new CategoryDto();
                CategoryModel categoryModel = productModel.getCategoryModel();
                categoryDto.setId(categoryModel.getId());
                categoryDto.setName(categoryModel.getName());
                productDto.setCategoryDto(categoryDto);
            }


            productDtoList.add(productDto);

        }
        return productDtoList;
    }

    public ProductDto findProductById(Long id) {
        Optional<ProductModel> optionalProductModel = productRepository.findById(id);
        if (optionalProductModel.isPresent()) {
            ProductModel productModel = optionalProductModel.get();
            ProductDto productDto = new ProductDto();
            productDto.setId(productModel.getId());
            productDto.setName(productModel.getName());
            productDto.setPrice(productModel.getPrice());


            if (productModel.getManufacturerModel() != null) {
                ManufacturerDto manufacturerDto = new ManufacturerDto();
                ManufacturerModel manufacturerModel = productModel.getManufacturerModel();
                manufacturerDto.setId(manufacturerModel.getId());
                manufacturerDto.setName(manufacturerModel.getName());
                productDto.setManufacturerDto(manufacturerDto);
             }

            if (productModel.getCategoryModel() != null) {
                CategoryDto categoryDto = new CategoryDto();
                CategoryModel categoryModel = productModel.getCategoryModel();
                categoryDto.setId(categoryModel.getId());
                categoryDto.setName(categoryModel.getName());
                productDto.setCategoryDto(categoryDto);
            }

            return productDto;
        }
        return null;
    }

    public void addProduct(ProductDto productDto) {
        ProductModel productModel = new ProductModel();
        productModel.setName(productDto.getName());
        productModel.setPrice(productDto.getPrice());


        ManufacturerDto manufacturerDto = productDto.getManufacturerDto();
        if (manufacturerDto != null) {
            ManufacturerModel manufacturerModel = manufacturerRepository.findById(manufacturerDto.getId()).orElse(null);
            productModel.setManufacturerModel(manufacturerModel);
        }

        CategoryDto categoryDto = productDto.getCategoryDto();
        if (categoryDto != null) {
            CategoryModel categoryModel = categoryRepository.findById(categoryDto.getId()).orElse(null);
            productModel.setCategoryModel(categoryModel);
        }
        productRepository.save(productModel);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(ProductDto productDto) {
        Optional<ProductModel> optionalProductModel = productRepository.findById(productDto.getId());
        if (optionalProductModel.isPresent()) {
            ProductModel productModel = optionalProductModel.get();

            productModel.setName(productDto.getName());
            productModel.setPrice(productDto.getPrice());

            ManufacturerModel manufacturerModel = manufacturerRepository.findById(productDto.getManufacturerDto().getId()).orElse(null);
            productModel.setManufacturerModel(manufacturerModel);
            CategoryModel categoryModel = categoryRepository.findById(productDto.getCategoryDto().getId()).orElse(null);
            productModel.setCategoryModel(categoryModel);

            productRepository.save(productModel);
        }
    }
}
