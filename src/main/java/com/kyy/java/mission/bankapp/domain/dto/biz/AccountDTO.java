package com.kyy.java.mission.bankapp.domain.dto.biz;

import com.kyy.java.mission.bankapp.domain.vo.AccountVO;
import lombok.*;

import java.util.List;

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    int accountNumber; // 계좌번호
    int balance; // 금액
    CustomerDTO owner; // 한명의 고객
    List<TransactionDTO> transactions; // 여러개의 거래내역

    public static AccountDTO of(AccountDTO.AccountDTOBuilder accountDTOBuilder) {
        return accountDTOBuilder.build();
    }

    public static List<AccountDTO> from(List<AccountVO> accountVOList) {
        List<AccountDTO> accountDTOList = accountVOList.stream().map(accountVO -> AccountDTO.builder()
                .accountNumber(accountVO.getAccountNumber())
                .balance(accountVO.getBalance())
                .owner(CustomerDTO.builder()
                        .customerId(accountVO.getOwner().getCustomerId())
                        .name(accountVO.getOwner().getName())
                        .build())
                .build()).toList();
        return accountDTOList;
    }
}
