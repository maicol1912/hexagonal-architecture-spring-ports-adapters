package com.hexagonal.hexagonalarchitecture.adapter.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "name_product")
    private String nameProduct;

    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] image;
    @Column(name = "price",columnDefinition = "INTEGER DEFAULT 0")
    private Integer price;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
