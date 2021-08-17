package com.example.demo.model;

import javax.validation.constraints.NotNull;

public class CustomerEditRequest extends CustomerRequest{
    @NotNull
    private Integer id;

    public CustomerEditRequest() {
    }

    public Integer getId() {
        return id;
    }
}
