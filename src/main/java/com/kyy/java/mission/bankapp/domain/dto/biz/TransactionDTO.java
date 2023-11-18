package com.kyy.java.mission.bankapp.domain.dto.biz;

import com.kyy.java.mission.bankapp.domain.vo.TransactionVO;
import lombok.*;

import java.util.List;

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    int transactionId;
    String type;
    int amount;
    String date;
    AccountDTO account;

    public static TransactionDTO of(TransactionDTO.TransactionDTOBuilder transactionDTOBuilder) {
        return transactionDTOBuilder.build();
    }

    public static List<TransactionDTO> from(List<TransactionVO> transactionVOList) {
        List<TransactionDTO> transactionDTOList = transactionVOList.stream().map(transactionVO -> TransactionDTO.builder()
                .transactionId(transactionVO.getTransactionId())
                .type(transactionVO.getType())
                .amount(transactionVO.getAmount())
                .date(transactionVO.getDate())
                .account(AccountDTO.builder()
                        .accountNumber(transactionVO.getAccountVo().getAccountNumber())
                        .balance(transactionVO.getAccountVo().getBalance())
                        .owner(CustomerDTO.builder()
                                .customerId(transactionVO.getAccountVo().getOwner().getCustomerId())
                                .name(transactionVO.getAccountVo().getOwner().getName())
                                .build())
                        .build())
                .build()).toList();
        return transactionDTOList;
    }


}
