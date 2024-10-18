package com.vibutsx.nexivusSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vibutsx.nexivusSpring.entity.CategoryEntity;
import com.vibutsx.nexivusSpring.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryEntity>> getAll() {
        List<CategoryEntity> categories = categoryService.getAll();

        return ResponseEntity.status(200).body(categories);
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity entity) {
        CategoryEntity createdCategory = categoryService.createCategory(entity);
        
        return ResponseEntity.status(201).body(createdCategory );
    }
    
    
}
