package com.hexagonal.hexagonalarchitecture.adapter.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long idUser;

    @Column(name = "name_user", columnDefinition = "VARCHAR(40) CHECK (LENGTH(name_user) >= 10)",
            nullable = false, unique = false)
    @Size(min = 10,max = 40)
    private String name;

    @Column(name = "lastname_user", columnDefinition = "VARCHAR(40) CHECK (LENGTH(lastname_user) >= 10)", nullable = false, unique = false)
    @Size(min = 10,max = 40)
    private String lastname;

    @Column(name = "email_user", columnDefinition = "VARCHAR(40) CHECK (REGEXP_LIKE(email_user, '^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$') AND LENGTH(email_user) > 10)", nullable = false, unique = true)
    @Size(min = 11, max = 40)
    @Pattern(regexp = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$", message = "Formato de correo electrónico inválido")
    private String email;

    @Column(name = "username", columnDefinition = "VARCHAR(20) CHECK (LENGTH(username) >= 5)", nullable = false, unique = true, length = 20)
    @Size(min = 5,max = 20)
    private String username;

    @Column(name = "password_user", columnDefinition = "VARCHAR(350) CHECK (LENGTH(password_user) >= 5)", nullable = false, unique = false)
    @Size(min = 5,max = 100)
    private String password;

    @Column(name = "age_user", columnDefinition = "INTEGER CHECK (age_user > 16 AND age_user < 90)", nullable = false, unique = false)
    @Min(17)
    @Max(89)
    private Integer age;

    @Column(name = "address_user", columnDefinition = "VARCHAR(200) DEFAULT 'N/A'", nullable = true,unique = false)
    @Size(min = 2,max = 200)
    private String address;

    @ManyToMany(fetch = FetchType.EAGER , targetEntity = RoleEntity.class,cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity>roles;

}
