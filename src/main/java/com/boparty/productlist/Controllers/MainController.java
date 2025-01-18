package com.boparty.productlist.Controllers;

import com.boparty.productlist.Models.Product;
import com.boparty.productlist.Models.ProductsOrder;
import com.boparty.productlist.Models.RequestDTO;
import com.boparty.productlist.Services.OrderService;
import com.boparty.productlist.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private OrderService orderService;
    private ProductsService productsService;
    @Autowired
    public MainController(OrderService orderService, ProductsService productsService) {
        this.orderService = orderService;
        this.productsService = productsService;
    }
    @GetMapping("/")
    public String index(Model model) {
        List<ProductsOrder> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "index";
    }
    @GetMapping("/orders/{id}")
    public String order(@PathVariable Long id, Model model) {
        ProductsOrder order = orderService.findById(id);
        if(order == null) {
            return "redirect:/";
        }
        model.addAttribute("order", order);
        return "viewOrder";
    }


//    @PostMapping("/products/add")
//    public ResponseEntity<Product> addProduct(@RequestBody RequestDTO product) {
//        return new ResponseEntity<>(new Product(), HttpStatus.OK);
//    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody RequestDTO name) {
        Product prod = new Product();
        prod.setName(name.getParam1());
        prod.setAmount(name.getParam2());
        ProductsOrder order = orderService.findById(Long.parseLong(name.getParam3()));
        if(order == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        prod.setOrder(order);

        productsService.add(prod);
        prod.setOrder(null);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @PostMapping("/products/check/{id}")
    public ResponseEntity<Boolean> checkProduct(String isChecked, @PathVariable Long id) {
        Product prod = productsService.findById(id);
        if(prod == null) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

        boolean checked = Boolean.parseBoolean(isChecked);
        prod.setBought(!checked);
        productsService.add(prod);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @PostMapping("/products/selected")
    public ResponseEntity<List<Long>> selectedProducts(Long orderId) {
        List<Long> prodcts = productsService.findAll()
                .stream()
                .filter(x-> Objects.equals(x.getOrder().getId(), orderId) && x.isBought())
                .map(Product::getId)
                .toList();
        return new ResponseEntity<>(prodcts, HttpStatus.OK);

    }

    @PostMapping("/products/remove/{id}")
    public ResponseEntity<Boolean> removeProduct(@PathVariable Long id) {
        Product prod = productsService.findById(id);
        if(prod == null) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        productsService.remove(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/products/rename/{id}")
    public ResponseEntity<Boolean> renameProduct(@RequestParam String name, @PathVariable Long id) {
        Product prod = productsService.findById(id);
        if(prod == null) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
        prod.setName(name);
        productsService.add(prod);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
