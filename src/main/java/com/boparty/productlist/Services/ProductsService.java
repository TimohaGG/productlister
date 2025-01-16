package com.boparty.productlist.Services;

import com.boparty.productlist.Models.Product;
import com.boparty.productlist.Repos.ProductsRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepos productsRepos;
    public ProductsService(ProductsRepos productsRepos) {
        this.productsRepos = productsRepos;
    }

    public List<Product> findAll() {
        return productsRepos.findAll();
    }

    public Product add(Product product) {
        return productsRepos.save(product);
    }

    public Product findById(Long id) {
        return productsRepos.findById(id).orElse(null);
    }
}
