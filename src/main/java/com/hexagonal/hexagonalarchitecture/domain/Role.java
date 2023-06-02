package com.hexagonal.hexagonalarchitecture.domain;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.ERole;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    private ERole name;
}
