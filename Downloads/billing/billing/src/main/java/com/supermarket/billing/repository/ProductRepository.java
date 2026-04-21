package com.supermarket.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.supermarket.billing.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByBarcode(String barcode);

}