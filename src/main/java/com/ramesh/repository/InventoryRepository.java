package com.ramesh.repository;

import com.ramesh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Product,Integer> {
}
