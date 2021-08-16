package com.example.demo.model;

public class CustomerResponse {
    private Integer id;
    private String name;

    public CustomerResponse() {
    }

    public CustomerResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
