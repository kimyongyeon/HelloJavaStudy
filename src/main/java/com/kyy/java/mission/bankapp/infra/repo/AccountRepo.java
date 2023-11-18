package com.kyy.java.mission.bankapp.infra.repo;

import com.kyy.java.mission.bankapp.domain.vo.AccountVO;
import com.kyy.java.mission.bankapp.infra.MemRepo;

import java.util.List;

public interface AccountRepo extends MemRepo<AccountVO> {
    List<AccountVO> findAccountByIdList(int customerId);
}
