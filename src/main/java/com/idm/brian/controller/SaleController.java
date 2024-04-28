package com.idm.brian.controller;
import com.idm.brian.model.SaleModel;
import com.idm.brian.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    // Create a new sale
    @PostMapping("/add")
    public SaleModel addSale(@RequestBody SaleModel sale) {
        return saleRepository.save(sale);
    }

    // Get all sales
    @GetMapping("/all")
    public List<SaleModel> getAllSales() {
        return saleRepository.findAll();
    }

    // Get a specific sale by ID
    @GetMapping("/{id}")
    public Optional<SaleModel> getSaleById(@PathVariable long id) {
        return saleRepository.findById(id);
    }

    // Update an existing sale
    @PutMapping("/{id}")
    public SaleModel updateSale(@PathVariable long id, @RequestBody SaleModel newSale) {
        return saleRepository.findById(id)
                .map(sale -> {
                    sale.setAmount(newSale.getAmount());
                    sale.setDate(newSale.getDate());
                    return saleRepository.save(sale);
                })
                .orElseGet(() -> {
                    newSale.setSales_id(id);
                    return saleRepository.save(newSale);
                });
    }

    // Delete a sale by ID
    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable long id) {
        saleRepository.deleteById(id);
    }
}
