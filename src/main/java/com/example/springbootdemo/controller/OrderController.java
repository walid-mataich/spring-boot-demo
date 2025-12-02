package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Order;
import com.example.springbootdemo.service.OrderService;
import com.example.springbootdemo.service.ProductService;
import com.example.springbootdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderSvc;
    private final UserService userSvc;
    private final ProductService productSvc;

    public OrderController(OrderService o, UserService u, ProductService p) {
        this.orderSvc = o;
        this.userSvc = u;
        this.productSvc = p;
    }

    @GetMapping
    public String list(Model m) {
        m.addAttribute("orders", orderSvc.findAll());
        m.addAttribute("order", new Order());
        m.addAttribute("users", userSvc.findAll());
        m.addAttribute("products", productSvc.findAll());
        return "orders";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Order order) {
        orderSvc.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderSvc.delete(id);
        return "redirect:/orders";
    }
}
