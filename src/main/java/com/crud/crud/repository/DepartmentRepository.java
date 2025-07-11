package com.crud.crud.repository;

import com.crud.crud.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
    Optional<DepartmentEntity> findByNumber(Integer number);
}
