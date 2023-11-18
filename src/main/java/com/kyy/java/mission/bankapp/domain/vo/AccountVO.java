package com.kyy.java.mission.bankapp.domain.vo;

import com.kyy.java.mission.bankapp.domain.dto.biz.AccountDTO;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class AccountVO extends BaseVO {
    long id;
    int accountNumber; // 계좌번호
    int balance; // 금액
    CustomerVO owner; // 한명의 고객

    // DTO to VO
    public static AccountVO to(AccountDTO accountDTO) {
//        AccountVO accountVO = AccountVO.builder()
//                .accountNumber(accountDTO.getAccountNumber())
//                .balance(accountDTO.getBalance())
//                .owner(CustomerVO.to(accountDTO.getOwner()))
//                .build();
//        accountVO.setRegDate(LocalDateTime.now());
//        accountVO.setRegister("insertAdmin");
        return new AccountVO();
    }





}
