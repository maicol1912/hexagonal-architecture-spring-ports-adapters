package com.hexagonal.hexagonalarchitecture.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Integer price;
    @JsonIgnore
    private byte[] image;
    private Category category;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public void setImage(byte[] image) {
        this.image = image;
    }
}
