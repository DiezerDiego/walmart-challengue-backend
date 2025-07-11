package com.crud.crud.mappers.impl;

import com.crud.crud.entity.ItemEntity;
import com.crud.crud.mappers.ItemMapperInterface;
import com.crud.crud.records.request.ItemRecordRequest;
import com.crud.crud.records.responses.ItemRecordResponse;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperImpl implements ItemMapperInterface {

    @Override
    public ItemRecordResponse toRecord(ItemEntity itemEntity) {
        return ItemRecordResponse.builder()
                .number(itemEntity.getNumber())
                .description(itemEntity.getDescription())
                .price(itemEntity.getPrice())
                .description(itemEntity.getDescription())
                .barcode(itemEntity.getBarcode())
                .number(itemEntity.getNumber())
                .departmentNumber(itemEntity.getDepartmentNumber())
                .build();
    }

    @Override
    public ItemEntity toEntity(ItemRecordRequest itemRecordRequest) {
        return ItemEntity.builder()
                .number(itemRecordRequest.number())
                .description(itemRecordRequest.description())
                .price(itemRecordRequest.price())
                .barcode(itemRecordRequest.barcode())
                .departmentNumber(itemRecordRequest.departmentNumber())
                .build();
    }
}
