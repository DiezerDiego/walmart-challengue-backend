package com.crud.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "item",
        uniqueConstraints = @UniqueConstraint(columnNames = {"number"})
)
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private String description;
    private Integer departmentNumber;
    private String barcode;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
}
