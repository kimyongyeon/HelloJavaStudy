package com.kyy.java.mission.bankapp.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionVO extends BaseVO {
    long id;
    int transactionId;
    String type;
    int amount;
    String date;
    AccountVO accountVo;

    public static TransactionVO to(TransactionVO transactionVO) {
        TransactionVO transactionVO1 = TransactionVO.builder()
                .transactionId(transactionVO.getTransactionId())
                .type(transactionVO.getType())
                .amount(transactionVO.getAmount())
                .date(transactionVO.getDate())
                .accountVo(transactionVO.getAccountVo())
                .build();
        transactionVO1.setRegDate(transactionVO.getRegDate());
        transactionVO1.setRegister(transactionVO.getRegister());
        return transactionVO1;
    }
}
