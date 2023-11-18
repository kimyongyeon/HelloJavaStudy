package com.kyy.java.mission.bankapp.infra.repo.impl;

import com.kyy.java.mission.bankapp.domain.vo.AccountVO;
import com.kyy.java.mission.bankapp.infra.repo.AccountRepo;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AccountRepoImpl implements AccountRepo {

    private final List<AccountVO> accountVOList;

    @Override
    public void create(AccountVO AccountVO) {
        this.accountVOList.add(AccountVO);
    }

    @Override
    public void update(long id, AccountVO AccountVO) {
        this.accountVOList.stream()
                .filter(account -> account.getId() == id)
                .forEach(account -> {
                    account.setBalance(AccountVO.getBalance());
                    account.setOwner(AccountVO.getOwner());
                    account.setAccountNumber(account.getAccountNumber());
                    account.setModDate(LocalDateTime.now());
                    account.setModifier("SYSTEM");
                });
    }

    @Override
    public void delete(long id) {
        this.accountVOList.removeIf(account -> account.getAccountNumber() == id);
    }

    @Override
    public AccountVO findById(long id) {
        return this.accountVOList.stream()
                .filter(account -> account.getAccountNumber() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<AccountVO> findAll() {
        return this.accountVOList;
    }

    @Override
    public List<AccountVO> findAccountByIdList(int customerId) {
        return this.accountVOList.stream()
                .filter(account -> account.getOwner().getCustomerId() == customerId)
                .collect(Collectors.toList());
    }
}
