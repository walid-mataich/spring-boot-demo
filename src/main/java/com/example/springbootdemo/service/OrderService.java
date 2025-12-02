package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Order;
import com.example.springbootdemo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> findAll() {
        return repo.findAll();
    }

    public Order save(Order o) {
        return repo.save(o);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
