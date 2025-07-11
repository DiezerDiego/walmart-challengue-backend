package com.crud.crud.service.impl;

import com.crud.crud.entity.DepartmentEntity;
import com.crud.crud.mappers.DepartmentMapperInterface;
import com.crud.crud.records.request.DepartmentRecordRequest;
import com.crud.crud.records.responses.DepartmentRecordResponse;
import com.crud.crud.repository.DepartmentRepository;
import com.crud.crud.service.DepartmentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentServiceInterface {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapperInterface departmentMapperInterface;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapperInterface departmentMapperInterface) {
        this.departmentRepository = departmentRepository;
        this.departmentMapperInterface = departmentMapperInterface;
    }

    public List<DepartmentRecordResponse> getAll(){
        return departmentRepository.findAll().stream().map(departmentMapperInterface::toRecord).toList();
    }
    public DepartmentRecordResponse getByNumber(Integer number) {
        return departmentRepository.findByNumber(number).map(departmentMapperInterface::toRecord).orElse(null);
    }
    public DepartmentRecordResponse save(DepartmentRecordRequest department) {
        Optional<DepartmentEntity> existing = departmentRepository.findByNumber(department.number());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Department with number " + department.number() + " already exists.");
        }
        DepartmentEntity entity = departmentMapperInterface.toEntity(department);
        DepartmentEntity saved = departmentRepository.save(entity);
        return departmentMapperInterface.toRecord(saved);
    }
    public void delete(Integer number) {
        DepartmentEntity entity = departmentRepository.findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Department with number  " + number + " does not exist."));
        departmentRepository.deleteById(entity.getId());
    }
    public DepartmentRecordResponse update(Integer number, DepartmentRecordRequest department) {
        DepartmentEntity existing = departmentRepository.findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Department with  number " + number + " does not exist."));
        if (department.description() != null) {
            existing.setDescription(department.description());
        }
        return departmentMapperInterface.toRecord(departmentRepository.save(existing));
    }
}
