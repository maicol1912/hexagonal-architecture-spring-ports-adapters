package com.hexagonal.hexagonalarchitecture.adapter.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private EStatusPurchase status = EStatusPurchase.PENDING;
}
