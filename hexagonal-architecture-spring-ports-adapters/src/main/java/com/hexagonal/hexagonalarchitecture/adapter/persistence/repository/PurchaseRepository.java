package com.hexagonal.hexagonalarchitecture.adapter.persistence.repository;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {
}
