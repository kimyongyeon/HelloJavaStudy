package com.kyy.java.mission.bankapp.infra.repo.impl;

import com.kyy.java.mission.bankapp.domain.vo.TransactionVO;
import com.kyy.java.mission.bankapp.infra.MemRepo;
import com.kyy.java.mission.bankapp.infra.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionRepoImpl implements TransactionRepo {

    List<TransactionVO> TransactionVOList;

    @Override
    public void create(TransactionVO TransactionVO) {
        this.TransactionVOList.add(TransactionVO);
    }

    @Override
    public void update(long id, TransactionVO TransactionVO) {
        this.TransactionVOList.stream()
                .filter(transaction -> transaction.getTransactionId() == id)
                .forEach(transaction -> {
            transaction.setAmount(TransactionVO.getAmount());
            transaction.setAccountVo(TransactionVO.getAccountVo());
            transaction.setTransactionId(transaction.getTransactionId());
        });
    }

    @Override
    public void delete(long id) {
        this.TransactionVOList.removeIf(transaction -> transaction.getTransactionId() == id);
    }

    @Override
    public TransactionVO findById(long id) {
        return this.TransactionVOList.stream()
                .filter(transaction -> transaction.getTransactionId() == id)
                .findFirst().orElseThrow();
    }

    @Override
    public List<TransactionVO> findAll() {
        return this.TransactionVOList;
    }
}
