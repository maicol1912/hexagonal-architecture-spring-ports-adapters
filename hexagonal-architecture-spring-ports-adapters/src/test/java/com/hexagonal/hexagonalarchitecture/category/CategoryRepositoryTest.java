package com.hexagonal.hexagonalarchitecture.category;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.CategoryEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    // se ejecuta despues de que finaliza cada test
    @AfterEach
    void tearDown(){
        categoryRepository.deleteAll();
    }
    @Test
    void itShouldCheckWhenCategoryExists(){
        CategoryEntity category = CategoryEntity.builder().descriptionCategory("for the houses").nameCategory("Houses").build();
        categoryRepository.save(category);

        Optional<CategoryEntity> categorySelected = categoryRepository.findById(category.getIdCategory());

        assertThat(categorySelected).isNotEmpty();
    }

    @Test
    void itShouldCheckWhenCategoryNotExists(){
        CategoryEntity category = CategoryEntity.builder().descriptionCategory("for the houses").nameCategory("Houses").build();
        categoryRepository.save(category);

        Optional<CategoryEntity> categorySelected = categoryRepository.findById(10L);

        assertThat(categorySelected).isEmpty();
    }
}
