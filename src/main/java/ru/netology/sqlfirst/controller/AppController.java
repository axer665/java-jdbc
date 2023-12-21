package ru.netology.sqlfirst.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sqlfirst.entity.Customer;
import ru.netology.sqlfirst.service.AppService;

import java.util.List;

@RestController
public class AppController {
    private final AppService service;

    AppController(AppService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProduct(@RequestParam String name) {
        return service.getProduct(name);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }
}