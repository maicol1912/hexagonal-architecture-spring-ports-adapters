package com.hexagonal.hexagonalarchitecture.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private Long idCategory;
    private String nameCategory;
    private String descriptionCategory;
}
