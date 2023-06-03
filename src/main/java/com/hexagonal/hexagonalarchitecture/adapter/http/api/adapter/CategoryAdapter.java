package com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter;

import com.hexagonal.hexagonalarchitecture.application.port.api.CategoryApiPort;
import com.hexagonal.hexagonalarchitecture.application.service.CategoryServiceImpl;
import com.hexagonal.hexagonalarchitecture.application.service.ProductServiceImpl;
import com.hexagonal.hexagonalarchitecture.domain.Category;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Adapter;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Adapter
@AllArgsConstructor
public class CategoryAdapter implements CategoryApiPort {

    private CategoryServiceImpl categoryService;
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryService.saveCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryService.updateCategory(category);
    }

    @Override
    public String deleteCategory(Long id) {
        return categoryService.deleteCategory(id);
    }
}
