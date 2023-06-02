package com.hexagonal.hexagonalarchitecture.adapter.http.api.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Null
    private Long id;

    @NotBlank
    @Size(min = 10,max = 40)
    private String name;

    @NotBlank
    @Size(min = 10 ,max = 40)
    private String lastname;

    @Email
    @Size(min = 10,max = 40)
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 5,max = 20)
    private String username;

    @NotBlank
    @Size(min = 5, max = 35)
    private String password;

    @NotNull
    @Min(16)
    @Max(90)
    private Integer age;

    @NotBlank
    @Size(min = 10,max = 50)
    private String address;
}
