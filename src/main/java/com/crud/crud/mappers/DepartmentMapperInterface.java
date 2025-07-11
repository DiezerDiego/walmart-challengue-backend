package com.crud.crud.mappers;

import com.crud.crud.entity.DepartmentEntity;
import com.crud.crud.records.request.DepartmentRecordRequest;
import com.crud.crud.records.responses.DepartmentRecordResponse;
import org.springframework.stereotype.Component;


public interface DepartmentMapperInterface
{
    DepartmentRecordResponse toRecord(DepartmentEntity departmentEntity);
    DepartmentEntity toEntity(DepartmentRecordRequest departmentRecordRequest);
}
