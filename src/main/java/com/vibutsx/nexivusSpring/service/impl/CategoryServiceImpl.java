package com.vibutsx.nexivusSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vibutsx.nexivusSpring.entity.CategoryEntity;
import com.vibutsx.nexivusSpring.repository.CategoryRepository;
import com.vibutsx.nexivusSpring.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    
}
