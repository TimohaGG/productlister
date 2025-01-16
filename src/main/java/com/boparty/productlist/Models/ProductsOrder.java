package com.boparty.productlist.Models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class ProductsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orderDate;
    private String name;

    @OneToMany(mappedBy = "order")
    private List<Product> productsList;

    public Long getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }
}
