package com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.PurchaseDTO;
import com.hexagonal.hexagonalarchitecture.application.port.api.PurchaseApiPort;
import com.hexagonal.hexagonalarchitecture.application.service.PurchaseService;
import com.hexagonal.hexagonalarchitecture.domain.Purchase;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Adapter;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import lombok.AllArgsConstructor;

@Adapter
@AllArgsConstructor
public class PurchaseAdapter implements PurchaseApiPort {

    private MapStructClassMapper mapper;
    private PurchaseService purchaseService;

    @Override
    public String createPurchase(PurchaseDTO purchaseDTO) {
        return purchaseService.createPurchase(mapper.mapperClass(purchaseDTO, Purchase.class));
    }
}
