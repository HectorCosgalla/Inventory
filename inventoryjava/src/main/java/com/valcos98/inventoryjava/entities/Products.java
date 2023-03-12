package com.valcos98.inventoryjava.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products{
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    private Long productId;

    @Column(
        name = "product_name"
    )
    private String name;

    @Column(
        name = "product_description"
    )
    private String description;

    @Column(
        name = "stock"
    )
    private int stock;

    @Column(
        name = "price"
    )
    private int price;

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
