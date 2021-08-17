package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.model.CustomerRequest;
import com.example.demo.model.CustomerResponse;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/list")
    @ResponseBody
    public List<CustomerResponse> getCustomers() {

        return this.customerService.getCustomers();
    }

    @PostMapping("/customer")
    @ResponseBody
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @PutMapping("/customer/id")
    @ResponseBody
    public String updateCustomer() {
        return "";
    }

    @Service
    public static class CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

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

        public ResponseEntity createCustomer(CustomerRequest customerRequest) {
            Customer customer = customerRepository.findByName(customerRequest.getName());
            if (null!=customer) return new ResponseEntity<>("Customer existent.", HttpStatus.ACCEPTED);
            return new ResponseEntity<>("Customer created.", HttpStatus.CREATED);
        }

    }
}
