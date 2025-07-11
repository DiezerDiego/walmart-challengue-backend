package com.crud.crud.records.responses;

import lombok.Builder;

@Builder
public record DepartmentRecordResponse(Integer number, String description) {
}
