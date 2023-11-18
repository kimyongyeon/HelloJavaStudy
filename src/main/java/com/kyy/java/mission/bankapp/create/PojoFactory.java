package com.kyy.java.mission.bankapp.create;

import com.kyy.java.mission.bankapp.domain.service.AccountService;
import com.kyy.java.mission.bankapp.domain.service.CustomerService;
import com.kyy.java.mission.bankapp.domain.service.TransactionService;
import com.kyy.java.mission.bankapp.infra.MemStore;
import com.kyy.java.mission.bankapp.infra.repo.AccountRepo;
import com.kyy.java.mission.bankapp.infra.repo.CustomerRepo;
import com.kyy.java.mission.bankapp.infra.repo.TransactionRepo;
import com.kyy.java.mission.bankapp.infra.repo.impl.AccountRepoImpl;
import com.kyy.java.mission.bankapp.infra.repo.impl.CustomerRepoImpl;
import com.kyy.java.mission.bankapp.infra.repo.impl.TransactionRepoImpl;

public class PojoFactory {



    public static AccountRepo createAccountRepo() {
        return new AccountRepoImpl(MemStore.accountVOList);
    }

    public static CustomerRepo createCustomerRepo() {
        return new CustomerRepoImpl(MemStore.CustomerVOList);
    }

    public static TransactionRepo createTransactionRepo() {
        return new TransactionRepoImpl();
    }

    public static AccountService createAccountService() {
        return new AccountService(createAccountRepo(), createTransactionRepo());
    }

    public static CustomerService createCustomerService() {
        return new CustomerService(createCustomerRepo(), createAccountRepo());
    }

    public static TransactionService createTransactionService() {
        return new TransactionService(createTransactionRepo());
    }


}
