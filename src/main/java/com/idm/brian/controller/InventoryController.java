package com.idm.brian.controller;

import com.idm.brian.model.InventoryModel;
import com.idm.brian.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class InventoryController {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // Create a new inventory entry
    @PostMapping("/add")
    public InventoryModel addInventory(@RequestBody InventoryModel inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<InventoryModel> getAllInventory() {
        return inventoryRepository.findAll();
    }

}
