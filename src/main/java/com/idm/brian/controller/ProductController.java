package com.idm.brian.controller;
import com.idm.brian.model.ProductModel;
import com.idm.brian.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a new product
    @PostMapping("/add")
    public ProductModel addProduct(@RequestBody ProductModel product) {
        return productRepository.save(product);
    }

    // Get all products
    @GetMapping("/all")
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a specific product by ID
    @GetMapping("/{id}")
    public Optional<ProductModel> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ProductModel updateProduct(@PathVariable Long id, @RequestBody ProductModel newProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setProduct_name(newProduct.getProduct_name());
                    product.setProduct_price(newProduct.getProduct_price());
                    product.setProduct_quantity(newProduct.getProduct_quantity());
                    product.setProduct_description(newProduct.getProduct_description());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setProduct_id(id);
                    return productRepository.save(newProduct);
                });
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
