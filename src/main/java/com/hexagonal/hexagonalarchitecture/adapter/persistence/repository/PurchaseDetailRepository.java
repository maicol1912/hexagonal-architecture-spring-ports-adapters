package com.hexagonal.hexagonalarchitecture.adapter.persistence.repository;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.PurchaseDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetailEntity,Long> {
}
