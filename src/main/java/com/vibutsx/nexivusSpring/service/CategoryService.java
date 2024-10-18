package com.vibutsx.nexivusSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vibutsx.nexivusSpring.entity.CategoryEntity;

@Service
public interface CategoryService {
    CategoryEntity createCategory(CategoryEntity categoryEntity);
    List<CategoryEntity> getAll();
    CategoryEntity getById(Long id);
}
