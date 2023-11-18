package com.kyy.java.mission.bankapp.infra;

import com.kyy.java.mission.bankapp.domain.dto.biz.AccountDTO;
import com.kyy.java.mission.bankapp.domain.dto.biz.TransactionDTO;
import com.kyy.java.mission.bankapp.domain.vo.AccountVO;
import com.kyy.java.mission.bankapp.domain.vo.CustomerVO;
import com.kyy.java.mission.bankapp.domain.vo.TransactionVO;
import com.kyy.java.mission.shopapp.domain.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class MemStore {
    public static List<AccountVO> accountVOList = new ArrayList<>();

    public static List<CustomerVO> CustomerVOList = new ArrayList<>();

}
