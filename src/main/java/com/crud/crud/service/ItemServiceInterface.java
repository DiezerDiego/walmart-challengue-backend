package com.crud.crud.service;

import com.crud.crud.records.request.ItemRecordRequest;
import com.crud.crud.records.responses.ItemRecordResponse;

import java.util.List;

public interface ItemServiceInterface {
    List<ItemRecordResponse> getAll();
    ItemRecordResponse getByNumber(Integer number);
    ItemRecordResponse save(ItemRecordRequest item);
    void delete(Integer number);
    ItemRecordResponse update(Integer number, ItemRecordRequest item);
    List<ItemRecordResponse> getByDepartmentNumber(Integer departmentNumber);
}
