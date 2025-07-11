package com.crud.crud.mappers.impl;

import com.crud.crud.entity.DepartmentEntity;
import com.crud.crud.mappers.DepartmentMapperInterface;
import com.crud.crud.records.request.DepartmentRecordRequest;
import com.crud.crud.records.responses.DepartmentRecordResponse;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapperImpl implements DepartmentMapperInterface {
    @Override
    public DepartmentRecordResponse toRecord(DepartmentEntity departmentEntity) {
        return DepartmentRecordResponse.builder()
                .number(departmentEntity.getNumber())
                .description(departmentEntity.getDescription())
                .build();
    }

    @Override
    public DepartmentEntity toEntity(DepartmentRecordRequest departmentRecordRequest) {
        return DepartmentEntity.builder()
                .number(departmentRecordRequest.number())
                .description(departmentRecordRequest.description())
                .build();
    }
}
