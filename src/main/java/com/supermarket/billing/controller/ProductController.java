package com.supermarket.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.supermarket.billing.model.Product;
import com.supermarket.billing.repository.ProductRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    // ✅ GET ALL
    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // ✅ ADD PRODUCT
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // ✅ GET BY BARCODE
    @GetMapping("/barcode/{code}")
    public Product getByBarcode(@PathVariable String code) {
        return repo.findByBarcode(code);
    }

    // ✅ DELETE PRODUCT
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repo.deleteById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {

        System.out.println("UPDATE ID: " + id);
        System.out.println("Product Name: " + product.getName());

        product.setId(id);
        return repo.save(product);
    }
    @PutMapping("/reduce-stock/{id}/{qty}")
    public Product reduceStock(@PathVariable Long id, @PathVariable int qty) {

        Product product = repo.findById(id).orElseThrow();

        product.setStock(product.getStock() - qty);

        return repo.save(product);
    }
}