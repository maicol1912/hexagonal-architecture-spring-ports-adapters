package com.hexagonal.hexagonalarchitecture.adapter.persistence.model;

import jakarta.persistence.*;
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
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(40) CHECK (LENGTH(name) >= 10)",
            nullable = false, unique = false)
    private String name;

    @Column(name = "lastname", columnDefinition = "VARCHAR(40) CHECK (LENGTH(lastname) >= 10)", nullable = false, unique = false)
    private String lastname;

    @Column(name = "email", columnDefinition = "VARCHAR(40) CHECK (REGEXP_LIKE(email, '^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$') AND LENGTH(email) > 10)", nullable = false, unique = true)
    private String email;

    @Column(name = "username", columnDefinition = "VARCHAR(20) CHECK (LENGTH(username) >= 5)", nullable = false, unique = true, length = 20)
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(350) CHECK (LENGTH(password) >= 5)", nullable = false, unique = false)
    @Size(min = 5,max = 100)
    private String password;

    @Column(name = "age", columnDefinition = "INTEGER CHECK (age > 16 AND age < 90)", nullable = false, unique = false)
    private Integer age;

    @Column(name = "address", columnDefinition = "VARCHAR(200) DEFAULT 'N/A'", nullable = true)
    private String address;

    @ManyToMany(fetch = FetchType.EAGER , targetEntity = RoleEntity.class,cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity>roles;
}
