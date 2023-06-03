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

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
