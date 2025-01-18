package com.boparty.productlist.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String amount;
    @ColumnDefault("false")
    private boolean isBought;

    @ManyToOne
    private ProductsOrder order;

    public Product() {}
    public ProductsOrder getOrder() {
        return order;
    }

    public void setOrder(ProductsOrder order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String product) {
        this.name = product;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean isBought) {
        this.isBought = isBought;
    }



}
