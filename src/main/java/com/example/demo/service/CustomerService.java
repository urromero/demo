package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.model.CustomerResponse;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponse> getCustomers() {
        System.out.println("prueba");
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        if (null!=customerList) {
            for (Customer customer : customerList) {
                customerResponseList.add(new CustomerResponse(customer.getId(), customer.getName()));
            }
        }
        return customerResponseList;
    }

}
