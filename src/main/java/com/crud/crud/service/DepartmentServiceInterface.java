package com.crud.crud.service;

import com.crud.crud.records.request.DepartmentRecordRequest;
import com.crud.crud.records.responses.DepartmentRecordResponse;

import java.util.List;

public interface DepartmentServiceInterface {
    List<DepartmentRecordResponse> getAll();
    DepartmentRecordResponse getByNumber(Integer number);
    DepartmentRecordResponse save(DepartmentRecordRequest department);
    void delete(Integer number);
    DepartmentRecordResponse update(Integer id, DepartmentRecordRequest department);
}
