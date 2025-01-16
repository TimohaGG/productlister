package com.boparty.productlist.Services;

import com.boparty.productlist.Models.ProductsOrder;
import com.boparty.productlist.Repos.OrdersRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrdersRepos ordersRepos;
    public OrderService(OrdersRepos ordersRepos) {
        this.ordersRepos = ordersRepos;
    }

    public List<ProductsOrder> findAll() {
        return ordersRepos.findAll();
    }

    public ProductsOrder findById(Long id) {
        return ordersRepos.findById(id).orElse(null);
    }
}
