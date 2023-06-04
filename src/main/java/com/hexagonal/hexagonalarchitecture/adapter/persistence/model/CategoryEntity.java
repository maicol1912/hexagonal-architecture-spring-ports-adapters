package com.hexagonal.hexagonalarchitecture.adapter.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long idCategory;
    @Column
    private String nameCategory;
    private String descriptionCategory;
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @PrePersist
    protected void onCreate(){
        this.creationDate = new Date();
    }
}
