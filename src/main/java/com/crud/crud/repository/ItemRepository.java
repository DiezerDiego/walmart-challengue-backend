package com.crud.crud.repository;

import com.crud.crud.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {
    List<ItemEntity> findByDepartmentNumber(Integer departmentNumber);
    Optional<ItemEntity> findByNumber(Integer number);
}
