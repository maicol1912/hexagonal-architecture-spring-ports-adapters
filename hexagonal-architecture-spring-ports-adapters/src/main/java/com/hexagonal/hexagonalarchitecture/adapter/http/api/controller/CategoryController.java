package com.hexagonal.hexagonalarchitecture.adapter.http.api.controller;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter.CategoryAdapter;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter.ProductAdapter;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.CategoryDTO;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.ProductDTO;
import com.hexagonal.hexagonalarchitecture.domain.Category;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CategoryController {

    private CategoryAdapter categoryAdapter;
    private MapStructClassMapper mapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryAdapter.getAllCategories().stream()
                .map(category -> mapper.mapperClass(category, CategoryDTO.class)).toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoryDTO>>getCategory(@PathVariable("id")Long id){
        return ResponseEntity.ok(Optional.ofNullable(mapper
                .mapperClass(categoryAdapter.getCategoryById(id), CategoryDTO.class)));
    }

    @PostMapping("/api/v1/category")
    public ResponseEntity<CategoryDTO>saveCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        Category category = mapper.mapperClass(categoryDTO,Category.class);
        return ResponseEntity.ok(mapper.mapperClass(categoryAdapter.saveCategory(category),CategoryDTO.class));
    }

    @PutMapping
    public ResponseEntity<CategoryDTO>updateCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = mapper.mapperClass(categoryDTO,Category.class);
        return ResponseEntity.ok(mapper.
                mapperClass(categoryAdapter.updateCategory(category),CategoryDTO.class));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteCategory(@PathVariable("id")Long id){
        return ResponseEntity.ok(categoryAdapter.deleteCategory(id));
    }
}
