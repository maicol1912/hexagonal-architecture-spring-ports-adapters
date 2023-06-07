package com.hexagonal.hexagonalarchitecture.adapter.http.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {

    public Long clientId;
    public List<Long>productId;
}
