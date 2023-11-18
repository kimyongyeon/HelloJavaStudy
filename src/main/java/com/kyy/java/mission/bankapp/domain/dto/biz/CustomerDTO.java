package com.kyy.java.mission.bankapp.domain.dto.biz;

import com.kyy.java.mission.bankapp.domain.vo.CustomerVO;
import com.kyy.java.mission.bankapp.infra.repo.CustomerRepo;
import lombok.*;

import java.util.List;

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    int customerId;
    String name;
    List<AccountDTO> accounts; // 계좌번호

    public static CustomerDTO of(CustomerDTO.CustomerDTOBuilder customerDTOBuilder) {
        return customerDTOBuilder.build();
    }

    public static List<CustomerVO> from(List<CustomerDTO> customerDTOList) {
        List<CustomerVO> customerVOList = customerDTOList.stream().map(customerDTO -> CustomerVO.builder()
                .customerId(customerDTO.getCustomerId())
                .name(customerDTO.getName())
                .build()).toList();
        return customerVOList;
    }
}


