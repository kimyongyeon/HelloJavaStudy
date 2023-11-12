package com.kyy.java.addstudy;

import java.util.List;

public class Customer {

    List<String> memberList;

    public Customer() {

    }

    public Customer(List<String> list) {
        this.memberList = list;
    }

    void getMemberStaticList() {
        ViewMain.staticMemberList.add("2");
        System.out.println(ViewMain.staticMemberList);
    }

    void getMemberList() {
//        ViewMain viewMain = new ViewMain();
        memberList.add("2");
        System.out.println(memberList);
    }
}
