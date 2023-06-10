package com.hexagonal.hexagonalarchitecture.application.port.api;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.PurchaseDTO;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Port;

@Port
public interface PurchaseApiPort {

    String createPurchase(PurchaseDTO purchaseDTO);
}
