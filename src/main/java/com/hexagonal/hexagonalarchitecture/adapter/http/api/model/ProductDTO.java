package com.hexagonal.hexagonalarchitecture.adapter.http.api.model;

import com.hexagonal.hexagonalarchitecture.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long idProduct;
    private String nameProduct;
    private MultipartFile image;
    private Integer price;
    private Long category;
}
