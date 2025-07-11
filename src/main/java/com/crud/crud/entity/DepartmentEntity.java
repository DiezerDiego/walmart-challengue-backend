package com.crud.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(
        name = "department",
        uniqueConstraints = @UniqueConstraint(columnNames = {"number"})
)
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private String description;
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private List<ItemEntity> items;
}
