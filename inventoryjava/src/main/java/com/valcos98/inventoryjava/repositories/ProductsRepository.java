package com.valcos98.inventoryjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valcos98.inventoryjava.entities.Products;

public interface ProductsRepository extends JpaRepository<Products,Long> {
}
