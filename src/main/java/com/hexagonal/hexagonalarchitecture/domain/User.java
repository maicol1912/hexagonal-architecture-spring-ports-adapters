package com.hexagonal.hexagonalarchitecture.domain;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.RoleEntity;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

//* CLASE USADA EN LA CAPA DE APPLICATION
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long idUser;
    private String name;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Integer age;
    private String address;
    private Set<RoleEntity>roles;
}
