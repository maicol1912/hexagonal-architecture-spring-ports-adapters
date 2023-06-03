package com.hexagonal.hexagonalarchitecture.domain;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.CategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long idProduct;
    private String nameProduct;
    private Category category;
}
