package com.crud.crud.controller;

import com.crud.crud.records.request.DepartmentRecordRequest;
import com.crud.crud.records.responses.DepartmentRecordResponse;
import com.crud.crud.service.DepartmentServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentServiceInterface departmentServiceInterface;

    public DepartmentController(DepartmentServiceInterface departmentServiceInterface) {
        this.departmentServiceInterface = departmentServiceInterface;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentRecordResponse>> getAll(){

        List<DepartmentRecordResponse> departmentEntityList= departmentServiceInterface.getAll();
        if(departmentEntityList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(departmentEntityList);
    }
    @GetMapping("/by-number/{number}")
    public ResponseEntity<DepartmentRecordResponse> getByNumber( @PathVariable("number") Integer number) {
        DepartmentRecordResponse department = departmentServiceInterface.getByNumber(number);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }
    @PostMapping
    public ResponseEntity<DepartmentRecordResponse> save(@RequestBody @Validated DepartmentRecordRequest department) {
        DepartmentRecordResponse departmentNew = departmentServiceInterface.save(department);
        return ResponseEntity.ok(departmentNew);
    }
    @DeleteMapping("/{number}")
    public ResponseEntity<Void> delete(@PathVariable("number") Integer number) {
        departmentServiceInterface.delete(number);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{number}")
    public ResponseEntity<DepartmentRecordResponse> update(@PathVariable("number") Integer number, @RequestBody @Validated DepartmentRecordRequest department) {
        DepartmentRecordResponse updatedDepartment = departmentServiceInterface.update(number,department);
        return ResponseEntity.ok(updatedDepartment);
    }
}
