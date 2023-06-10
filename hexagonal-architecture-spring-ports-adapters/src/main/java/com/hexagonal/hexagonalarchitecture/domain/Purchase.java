package com.hexagonal.hexagonalarchitecture.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {
    public Long clientId;
    public List<Long> productId;
}
