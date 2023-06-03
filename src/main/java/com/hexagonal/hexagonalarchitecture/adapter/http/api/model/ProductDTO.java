package com.hexagonal.hexagonalarchitecture.adapter.http.api.model;

import com.hexagonal.hexagonalarchitecture.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long idProduct;
    private String nameProduct;
    private Long category;
}
