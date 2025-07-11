package com.crud.crud.records.responses;

import lombok.Builder;

@Builder
public record ItemRecordResponse(Integer number, String description, Integer departmentNumber, String barcode, Double price) {
}
