package com.kyy.java.mission.shopapp.domain.service;

import com.kyy.java.mission.shopapp.domain.dto.CustomerDTO;
import com.kyy.java.mission.shopapp.infra.repo.MemRepo;

public class CustomerService {

    private final MemRepo<CustomerDTO> customerRepo;

    public CustomerService(MemRepo<CustomerDTO> customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerDTO getProfile(long id) {
        return customerRepo.findById(id);
    }

    public void registerProfile(CustomerDTO customer) {
        customerRepo.create(customer);
    }

    public void removeProfile(long id) {
        customerRepo.delete(id);
    }

    public void editProfile(long id, CustomerDTO customer) {

        CustomerDTO customerRepoById = customerRepo.findById(id);

        CustomerDTO updateCustomerDTO = CustomerDTO.of(customerRepoById.getId(), customer.getName(), customer.getEmail(), customer.getShippingAddress());

        customerRepo.update(id, updateCustomerDTO);
    }
}
