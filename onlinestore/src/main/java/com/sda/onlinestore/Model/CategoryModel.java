package com.sda.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Categories")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryModel parent;
    @OneToMany(mappedBy = "parent")
    private List<CategoryModel> children = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryModel", orphanRemoval = false)
    @JsonIgnoreProperties("categoryModel")
    private List<ProductModel> productModelList = new ArrayList();

    public CategoryModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryModel getParent() {
        return parent;
    }

    public void setParent(CategoryModel parent) {
        this.parent = parent;
    }

    public List<CategoryModel> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryModel> children) {
        this.children = children;
    }

    public List<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }
}
