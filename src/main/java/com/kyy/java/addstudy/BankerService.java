package com.kyy.java.addstudy;

import java.util.ArrayList;
import java.util.List;

public class BankerService {

    void getAccount() {
        BankConst.accountList.add(1);
        System.out.println(BankConst.accountList);
    }
}
