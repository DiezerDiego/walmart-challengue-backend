
package com.crud.crud.service.impl;

import com.crud.crud.entity.DepartmentEntity;
import com.crud.crud.entity.ItemEntity;
import com.crud.crud.mappers.ItemMapperInterface;
import com.crud.crud.records.request.ItemRecordRequest;
import com.crud.crud.records.responses.ItemRecordResponse;
import com.crud.crud.repository.DepartmentRepository;
import com.crud.crud.repository.ItemRepository;
import com.crud.crud.service.ItemServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemServiceInterface {

    private final ItemRepository itemRepository;
    private final DepartmentRepository departmentRepository;
    private final ItemMapperInterface itemMapper;
    public ItemServiceImpl(ItemRepository itemRepository, DepartmentRepository departmentRepository, ItemMapperInterface itemMapper) {
        this.itemRepository = itemRepository;
        this.departmentRepository = departmentRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemRecordResponse> getAll(){
        return itemRepository.findAll().stream().map(itemMapper::toRecord).toList();
    }
    public ItemRecordResponse getByNumber(Integer id) {
        return itemRepository.findByNumber(id).map(itemMapper::toRecord).orElse(null);
    }
    public ItemRecordResponse save(ItemRecordRequest item) {
        departmentRepository.findByNumber(item.departmentNumber())
                .orElseThrow(() -> new IllegalArgumentException("Department with number " + item.departmentNumber() + " does not exist."));
        Optional<ItemEntity> exists = itemRepository.findByNumber(item.number());
        if (exists.isPresent()) {
            throw new IllegalArgumentException("Item with number " + item.number() + " already exists for department " + item.departmentNumber());
        }
        ItemEntity itemEntity = itemMapper.toEntity(item);
        itemEntity.setDepartmentNumber(item.departmentNumber());
        return itemMapper.toRecord(itemRepository.save(itemEntity));
    }

    public void delete(Integer number) {
        ItemEntity entity= itemRepository.findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Item with number " + number + " does not exist."));
        itemRepository.deleteById(entity.getId());
    }
    public ItemRecordResponse update(Integer number, ItemRecordRequest item) {
        ItemEntity existingItem = itemRepository.findByNumber(number)
                .orElseThrow(() -> new IllegalArgumentException("Item with number " + number + " does not exist."));
        if (item.barcode() != null) {
            existingItem.setBarcode(item.barcode());
        }
        if (item.departmentNumber() != null) {

        DepartmentEntity departmentEntity= departmentRepository.findByNumber(item.departmentNumber()).orElseThrow(
                    () -> new IllegalArgumentException("Department with number " + item.departmentNumber() + " does not exist."
                    ));
            existingItem.setDepartment(departmentEntity);
            existingItem.setDepartmentNumber(item.departmentNumber());
        }
        if (item.price() != null) {
            existingItem.setPrice(item.price());
        }
        if (item.description() != null) {
            existingItem.setDescription(item.description());
        }

        return itemMapper.toRecord(itemRepository.save(existingItem));
    }

    @Override
    public List<ItemRecordResponse> getByDepartmentNumber(Integer departmentNumber) {
        return itemRepository.findByDepartmentNumber(departmentNumber).stream().map(itemMapper::toRecord).toList();
    }
}
