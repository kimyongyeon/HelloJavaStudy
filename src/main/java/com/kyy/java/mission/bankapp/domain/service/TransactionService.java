package com.kyy.java.mission.bankapp.domain.service;

import com.kyy.java.mission.bankapp.domain.vo.TransactionVO;
import com.kyy.java.mission.bankapp.infra.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepo transactionRepo;

    public void execute(TransactionVO TransactionVO) {
        transactionRepo.create(TransactionVO);
    }
    public void revert(TransactionVO TransactionVO) {
        transactionRepo.delete(TransactionVO.getTransactionId());
    }


}
