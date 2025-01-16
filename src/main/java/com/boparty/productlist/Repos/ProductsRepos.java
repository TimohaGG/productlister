package com.boparty.productlist.Repos;

import com.boparty.productlist.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepos extends JpaRepository<Product,Long> {
}
