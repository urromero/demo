package com.example.demo.model;

import javax.validation.constraints.NotBlank;

public class CustomerRequest {
    @NotBlank
    private String name;

    public CustomerRequest() {
    }

    public String getName() {
        return name;
    }

}