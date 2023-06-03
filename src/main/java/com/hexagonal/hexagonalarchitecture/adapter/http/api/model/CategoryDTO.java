package com.hexagonal.hexagonalarchitecture.adapter.http.api.model;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @Null
    private Long idCategory;
    private String nameCategory;
    private String descriptionCategory;
}
