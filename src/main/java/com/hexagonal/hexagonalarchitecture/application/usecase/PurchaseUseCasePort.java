package com.hexagonal.hexagonalarchitecture.application.usecase;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.PurchaseDTO;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.ProductEntity;
import com.hexagonal.hexagonalarchitecture.domain.Purchase;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Port;

import java.util.List;

@Port
public interface PurchaseUseCasePort {

    String createPurchase(Purchase purchase);
}
