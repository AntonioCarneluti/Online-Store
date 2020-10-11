package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.CategoryDto;
import com.sda.onlinestore.model.CategoryModel;
import com.sda.onlinestore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private void addCategory(CategoryDto categoryDto){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryDto.getId());
        categoryModel.setName(categoryDto.getName());
        categoryRepository.save(categoryModel);
    }

    private List<CategoryDto> getCategories(){
        List<CategoryModel> categoryModelList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (CategoryModel categoryModel: categoryModelList){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(categoryModel.getId());
            categoryDto.setName(categoryModel.getName());
            List<CategoryModel> children = categoryModel.getChildren();
            List<CategoryDto> childrenDto = new ArrayList<>();
            for(CategoryModel child: children){
                CategoryDto childDto = new CategoryDto();
                childDto.setId(child.getId());
                childDto.setName(child.getName());
                childrenDto.add(childDto);
            }
            categoryDto.setChildren(childrenDto);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
