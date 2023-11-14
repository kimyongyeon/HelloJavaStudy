package com.kyy.java.mission.shopapp.domain.dto;

public class CustomerDTO {
    long id;
    String name;
    String email;
    String shippingAddress;


    private CustomerDTO() {}

    public static CustomerDTO of(long id, String name, String email, String shippingAddress) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.id = id;
        customerDTO.name = name;
        customerDTO.email = email;
        customerDTO.shippingAddress = shippingAddress;
        return customerDTO;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
