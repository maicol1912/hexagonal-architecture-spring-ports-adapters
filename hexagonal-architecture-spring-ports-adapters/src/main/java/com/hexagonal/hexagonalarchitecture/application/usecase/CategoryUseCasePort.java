package com.hexagonal.hexagonalarchitecture.application.usecase;

import com.hexagonal.hexagonalarchitecture.domain.Category;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Port;

import java.util.List;
import java.util.Optional;

@Port
public interface CategoryUseCasePort {
    Optional<Category> getCategoryById(Long id);
    Category saveCategory(Category category);
    List<Category> getAllCategories();
    Category updateCategory(Category category);
    String deleteCategory(Long id);
}
