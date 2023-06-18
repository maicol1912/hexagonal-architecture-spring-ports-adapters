package com.hexagonal.hexagonalarchitecture.category;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.CategoryEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.CategoryRepository;
import com.hexagonal.hexagonalarchitecture.application.service.CategoryServiceImpl;
import com.hexagonal.hexagonalarchitecture.domain.Category;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock  private CategoryRepository categoryRepository;
    @Mock MapStructClassMapper mapper;
    private CategoryServiceImpl categoryService;
    private AutoCloseable autoCloseable;
    // se corre antes de cada test
    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository,mapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
    @Test
    void getAllCtegories(){
        //when
        categoryService.getAllCategories();
        //then verifica que el servicio si llame al metodo del repostorio
        verify(categoryRepository).findAll();
    }

    @Test
    void addCategory(){
        Category category = Category.builder().descriptionCategory("for the houses").nameCategory("Houses").build();
        categoryService.saveCategory(category);

        ArgumentCaptor<CategoryEntity> categoryArgumentCaptor = ArgumentCaptor.forClass(CategoryEntity.class);
        //then verifica que el servicio si llame al metodo del repostorio
        verify(categoryRepository).save(categoryArgumentCaptor.capture());

        CategoryEntity capturedCategory = categoryArgumentCaptor.getValue();
        assertThat(capturedCategory).isEqualTo(mapper.mapperClass(category,CategoryEntity.class));
    }

    @Test
    @Disabled
    void deleteCategory(){

    }
}
