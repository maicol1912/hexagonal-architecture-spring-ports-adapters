package com.hexagonal.hexagonalarchitecture.adapter.persistence.repository;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
