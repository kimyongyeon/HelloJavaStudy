package com.kyy.java.mission.bankapp.domain.vo;

import com.kyy.java.mission.bankapp.domain.dto.biz.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerVO extends BaseVO {
    long id;
    int customerId;
    String name;

    public static CustomerVO to(CustomerDTO customerDTO) {
        CustomerVO customerVO = CustomerVO.builder()
                .customerId(customerDTO.getCustomerId())
                .name(customerDTO.getName())
                .build();
        customerVO.setRegDate(LocalDateTime.now());
        customerVO.setRegister("insertAdmin");
        return customerVO;
    }
}
