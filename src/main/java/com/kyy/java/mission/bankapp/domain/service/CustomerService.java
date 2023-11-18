package com.kyy.java.mission.bankapp.domain.service;

import com.kyy.java.mission.bankapp.domain.dto.biz.AccountDTO;
import com.kyy.java.mission.bankapp.domain.dto.biz.CustomerDTO;
import com.kyy.java.mission.bankapp.domain.vo.AccountVO;
import com.kyy.java.mission.bankapp.domain.vo.CustomerVO;
import com.kyy.java.mission.bankapp.infra.MemRepo;
import com.kyy.java.mission.bankapp.infra.repo.AccountRepo;
import com.kyy.java.mission.bankapp.infra.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;

    private final AccountRepo accountRepo;

    public void signUp(CustomerDTO customerDTO) {
        customerRepo.create(CustomerVO.to(customerDTO));
    }

    public void removeCustomer(int customerId) {
        customerRepo.delete(customerId);
    }

    public boolean auth(CustomerDTO customerDTO) {
        CustomerVO customerVO = customerRepo.findById(customerDTO.getCustomerId());
        if (customerVO == null) {
            return false;
        } else {
            return true;
        }
    }

    public CustomerDTO getCustomer(int customerId) {
        CustomerVO customerVO = customerRepo.findById(customerId);
        CustomerDTO customerDTO = CustomerDTO.builder()
                .customerId(customerVO.getCustomerId())
                .name(customerVO.getName())
                .build();

        return customerDTO;
    }

    public List<CustomerDTO> getCustomerList() {
        List<CustomerVO> all = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = all.stream()
                .map(customerVO -> CustomerDTO.builder()
                        .customerId(customerVO.getCustomerId())
                        .name(customerVO.getName())
                        .build())
                .collect(Collectors.toList());
        return customerDTOList;
    }

    public List<AccountDTO> getAccountDetails(int _customerId) {
        List<AccountVO> accountByIdList = accountRepo.findAccountByIdList(_customerId);
        return AccountDTO.from(accountByIdList);
    }


}
