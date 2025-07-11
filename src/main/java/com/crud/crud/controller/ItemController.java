
package com.crud.crud.controller;

import com.crud.crud.records.request.ItemRecordRequest;
import com.crud.crud.records.responses.ItemRecordResponse;
import com.crud.crud.service.ItemServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/department/items")
public class ItemController {

    private final ItemServiceInterface itemServiceInterface;

    public ItemController(ItemServiceInterface itemServiceInterface) {
        this.itemServiceInterface = itemServiceInterface;
    }

    @GetMapping("/by-department/{departmentNumber}")
    public ResponseEntity<List<ItemRecordResponse>> getAllByDepartmentNumber(@PathVariable ("departmentNumber") Integer departmentNumber) {
        List<ItemRecordResponse> itemRecordResponses=itemServiceInterface.getByDepartmentNumber(departmentNumber);
        if(itemRecordResponses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(itemRecordResponses);
    }
    @GetMapping
    public ResponseEntity<List<ItemRecordResponse>> getAll(){
        List<ItemRecordResponse> itemRecordResponses=itemServiceInterface.getAll();
        if(itemRecordResponses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(itemRecordResponses);
    }
    @GetMapping("/by-number/{number}")
    public ResponseEntity<ItemRecordResponse> getById( @PathVariable("number") Integer number) {
        ItemRecordResponse department = itemServiceInterface.getByNumber(number);
        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }
    @PostMapping
    public ResponseEntity<ItemRecordResponse> save(@RequestBody @Validated ItemRecordRequest department) {
        ItemRecordResponse departmentNew = itemServiceInterface.save(department);
        return ResponseEntity.ok(departmentNew);
    }
    @DeleteMapping("/{number}")
    public ResponseEntity<Void> delete(@PathVariable("number") Integer number) {
        itemServiceInterface.delete(number);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{number}")
    public ResponseEntity<ItemRecordResponse> update(@PathVariable("number") Integer number, @RequestBody @Validated ItemRecordRequest department) {
        ItemRecordResponse updatedDepartment = itemServiceInterface.update(number,department);
        return ResponseEntity.ok(updatedDepartment);
    }
}
