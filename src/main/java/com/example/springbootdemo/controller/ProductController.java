package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService svc;

    public ProductController(ProductService svc) {
        this.svc = svc;
    }

    @GetMapping
    public String list(Model m) {
        m.addAttribute("products", svc.findAll());
        m.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping("/save")
    public String save(Product p) {
        svc.save(p);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        svc.delete(id);
        return "redirect:/products";
    }
}
