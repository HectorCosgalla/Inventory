package com.valcos98.inventoryjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.valcos98.inventoryjava.entities.Products;
import com.valcos98.inventoryjava.repositories.ProductsRepository;

@Service
public class ProductsServices {
    private final ProductsRepository productsRepository;

    public ProductsServices(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    public Optional<Products> getById(Long id){
        return productsRepository.findById(id);
    }

    public void addProduct(Products product){
        productsRepository.save(product);
    }

    public List<Products> getAll(){
        return productsRepository.findAll();
    }

    public void deleteProduct(Products product){
        productsRepository.delete(product);
    }
}
