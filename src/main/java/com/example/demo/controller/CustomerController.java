package com.example.demo.controller;

import com.example.demo.model.CustomerResponse;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/list")
    @ResponseBody
    public List<CustomerResponse> getCustomers() {
        return this.customerService.getCustomers();
    }

    @PostMapping("/customer")
    @ResponseBody
    public String createCustomer() {
        return "";
    }

    @PutMapping("/customer")
    @ResponseBody
    public String updateCustomer() {
        return "";
    }

}
