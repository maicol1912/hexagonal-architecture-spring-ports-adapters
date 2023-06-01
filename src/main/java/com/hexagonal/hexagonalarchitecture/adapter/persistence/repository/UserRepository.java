package com.hexagonal.hexagonalarchitecture.adapter.persistence.repository;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
