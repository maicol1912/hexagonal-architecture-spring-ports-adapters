package com.hexagonal.hexagonalarchitecture.domain;

import lombok.*;

//* CLASE USADA EN LA CAPA DE APPLICATION
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastname;
    private Integer age;
    private String address;
}
