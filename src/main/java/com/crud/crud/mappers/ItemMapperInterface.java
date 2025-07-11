package com.crud.crud.mappers;

import com.crud.crud.entity.ItemEntity;
import com.crud.crud.records.request.ItemRecordRequest;
import com.crud.crud.records.responses.ItemRecordResponse;
import org.springframework.stereotype.Component;


public interface ItemMapperInterface
{
    ItemRecordResponse toRecord(ItemEntity itemEntity);
    ItemEntity toEntity(ItemRecordRequest itemRecordRequest);
}
