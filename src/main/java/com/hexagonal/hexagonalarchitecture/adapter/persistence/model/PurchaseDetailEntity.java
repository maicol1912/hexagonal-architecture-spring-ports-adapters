package com.hexagonal.hexagonalarchitecture.adapter.persistence.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private Integer amount;
}
