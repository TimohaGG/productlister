package com.boparty.productlist.Repos;

import com.boparty.productlist.Models.ProductsOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepos extends JpaRepository<ProductsOrder, Long> {
}
