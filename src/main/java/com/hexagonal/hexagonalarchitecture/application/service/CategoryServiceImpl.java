package com.hexagonal.hexagonalarchitecture.application.service;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.CategoryEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.CategoryRepository;
import com.hexagonal.hexagonalarchitecture.application.usecase.CategoryUseCasePort;
import com.hexagonal.hexagonalarchitecture.domain.Category;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryUseCasePort {

    private CategoryRepository categoryRepository;
    private MapStructClassMapper mapper;
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return Optional.ofNullable(mapper.mapperClass(categoryRepository.findById(id), Category.class));
    }

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = mapper.mapperClass(category,CategoryEntity.class);
        return mapper.mapperClass(categoryRepository.save(categoryEntity),Category.class);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream().map(category->
                mapper.mapperClass(category,Category.class)).collect(Collectors.toList());
    }

    @Override
    public Category updateCategory(Category category) {
        CategoryEntity categoryEntity = mapper.mapperClass(category,CategoryEntity.class);
        return mapper.mapperClass(categoryRepository.save(categoryEntity),Category.class);
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category deleted Success";
    }
}
