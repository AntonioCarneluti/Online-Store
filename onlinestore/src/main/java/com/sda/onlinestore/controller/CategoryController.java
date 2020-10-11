package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.CategoryDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/addCategory")
    public void addCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
    }

    @GetMapping("/getCategories")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    @PutMapping("/updateCategory")
    public void updateCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.updateCategory(categoryDto);
    }

    @GetMapping("/getById/{id}")
    public CategoryDto findByID(@PathVariable(name = "id") Long id) {
        return categoryService.findCategoryById(id);
    }


    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id) {
        categoryService.deleteCategory(id);
    }


}
