package com.crud.crud.records.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DepartmentRecordRequest(@NotNull Integer number, @NotBlank String description) {
}
