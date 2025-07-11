package com.crud.crud.records.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemRecordRequest(
        @NotNull Integer number,
        @NotBlank String description,
        @NotNull  Integer departmentNumber,
        @NotBlank String barcode,
        @NotNull  Double price) {
}
