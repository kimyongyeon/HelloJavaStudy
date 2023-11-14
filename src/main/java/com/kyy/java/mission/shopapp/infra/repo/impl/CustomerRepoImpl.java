package com.kyy.java.mission.shopapp.infra.repo.impl;

import com.kyy.java.mission.shopapp.domain.dto.CustomerDTO;
import com.kyy.java.mission.shopapp.domain.service.CustomerService;
import com.kyy.java.mission.shopapp.infra.repo.MemRepo;

import java.util.List;

public class CustomerRepoImpl implements MemRepo<CustomerDTO> {

    private List<CustomerDTO> customers;

    public CustomerRepoImpl(List<CustomerDTO> list) {
        customers = list;
    }

    @Override
    public void create(CustomerDTO customerDTO) {
        customers.add(customerDTO);
    }

    @Override
    public void update(long id, CustomerDTO customerDTO) {
        customers.stream().filter(customer -> customer.getId() == id).findFirst().ifPresent(customer -> {
            CustomerDTO.of(customer.getId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getShippingAddress());
        });
    }

    @Override
    public void delete(long id) {
        customers.remove((int) id);
    }

    @Override
    public CustomerDTO findById(long id) {
        return customers.stream().filter(customerDTO -> customerDTO.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customers;
    }
}
