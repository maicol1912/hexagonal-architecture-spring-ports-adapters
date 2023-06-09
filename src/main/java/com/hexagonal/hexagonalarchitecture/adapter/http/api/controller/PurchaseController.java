package com.hexagonal.hexagonalarchitecture.adapter.http.api.controller;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter.PurchaseAdapter;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.ProductDTO;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.PurchaseDTO;
import com.hexagonal.hexagonalarchitecture.application.service.PurchaseService;
import com.hexagonal.hexagonalarchitecture.domain.Product;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class PurchaseController {

    private PurchaseAdapter purchaseAdapter;

    @PostMapping(value="/api/v1/purchase")
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYED','USER')")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody PurchaseDTO purchaseDTO){
        return ResponseEntity.ok(purchaseAdapter.createPurchase(purchaseDTO));
    }
}
