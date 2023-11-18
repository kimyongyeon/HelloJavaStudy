package com.kyy.java.mission.bankapp;

import com.kyy.java.mission.bankapp.controller.RestController;
import com.kyy.java.mission.bankapp.create.PojoFactory;
import com.kyy.java.mission.bankapp.domain.dto.RequestDTO;
import com.kyy.java.mission.bankapp.domain.dto.biz.CustomerDTO;

import java.util.ArrayList;

public class BankMain {
    public static void main(String[] args) {
        System.out.println("Bank App Start");

        RestController restController = new RestController(
                PojoFactory.createCustomerService(),
                PojoFactory.createAccountService(),
                PojoFactory.createTransactionService()
        );

        RequestDTO<CustomerDTO> requestDTO = new RequestDTO<>();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("kyy");
        customerDTO.setCustomerId(1);
        customerDTO.setAccounts(new ArrayList<>());
        requestDTO.setData(customerDTO);
        restController.signUp(requestDTO);




    }
}
