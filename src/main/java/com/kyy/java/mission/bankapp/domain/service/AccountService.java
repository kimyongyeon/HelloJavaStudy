package com.kyy.java.mission.bankapp.domain.service;

import com.kyy.java.mission.bankapp.domain.dto.biz.AccountDTO;
import com.kyy.java.mission.bankapp.domain.dto.biz.TransactionDTO;
import com.kyy.java.mission.bankapp.domain.vo.AccountVO;
import com.kyy.java.mission.bankapp.domain.vo.TransactionVO;
import com.kyy.java.mission.bankapp.infra.repo.AccountRepo;
import com.kyy.java.mission.bankapp.infra.repo.TransactionRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountService {

    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;

    public void placeDeposit(int id, int amount) {
        try {
            deposit(id, amount);
            addTransaction(id, TransactionDTO.builder()
                    .type("deposit")
                    .amount(amount)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void placeWithdraw(int id, int amount) {
        try {
            withdraw(id, amount);
            addTransaction(id, TransactionDTO.builder()
                    .type("withdraw")
                    .amount(amount)
                    .build());
            // commit
        } catch (Exception e) {
            e.printStackTrace();
            // rollback
        }
    }

    public List<AccountDTO> getAccountList(int customerId) {
        List<AccountVO> accountByIdList = accountRepo.findAccountByIdList(customerId);
        return AccountDTO.from(accountByIdList);
    }

    // 계좌생성
    public void createAccount(AccountVO accountVo) {
        accountRepo.create(accountVo);
    }

    // 계좌삭제
    public void removeAccount(int accountId) {
        accountRepo.delete(accountId);
    }


    private void deposit(int id, int amount) {
        AccountVO byId = accountRepo.findById(id);
        if (byId == null) throw new RuntimeException("Account not found");
        byId.setBalance(byId.getBalance() + amount);
        accountRepo.update(id, byId);
    }

    private void withdraw(int id, int amount) {
        AccountVO byId = accountRepo.findById(id);
        if (byId == null) throw new RuntimeException("Account not found");
        byId.setBalance(byId.getBalance() - amount);
        accountRepo.update(id, byId);
    }

    private void addTransaction(int id, TransactionDTO transaction) {
        AccountVO byId = accountRepo.findById(id);
        if (byId == null) throw new RuntimeException("Account not found");
        // 거래내역 추가
        transactionRepo.create(TransactionVO.builder()
                .transactionId(transaction.getTransactionId())
                .type(transaction.getType())
                .amount(transaction.getAmount())
                .accountVo(byId)
                .build());
    }


}
