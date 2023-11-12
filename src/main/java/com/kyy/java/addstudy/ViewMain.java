package com.kyy.java.addstudy;

import java.util.ArrayList;
import java.util.List;

public class ViewMain {
    List<String> memberList = new ArrayList<>();

    static List<String> staticMemberList = new ArrayList<>();

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();



    public static void main(String[] args) {

        ViewMain viewMain = new ViewMain();
        viewMain.memberList.add("1");
//        System.out.println(viewMain.memberList);

        // 1. memberList 파라미터 넘기기
        Customer customer = new Customer(viewMain.memberList);
        customer.getMemberList(); // 1, 2

        // 2. static 공유 하기
        Customer customer2 = new Customer();
        staticMemberList.add("1");
        customer2.getMemberStaticList(); // 2

        List<Integer> accountList = List.of(1, 2, 3, 4, 5);
        // 싱글코어
        accountList.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        accountList.parallelStream().reduce((a, b) -> a + b).ifPresent(System.out::println);


        // 1 - 100
        for (int i = 0; i < 50; i++) {

        }
        for (int i = 51; i < 100; i++) {

        }

        // 동시성 제어 : 멀티쓰레드, 비동기 ... => 속도는 빠르지만, 코딩이 어렵다.
        Runnable bancker1 = () -> {
            BankerService bankerService = new BankerService();
            bankerService.getAccount();

        };
        bancker1.run();

        Runnable bancker2 = () -> { // 데드락
            MemberService memberService = new MemberService();
            memberService.getAccount();
        };
        bancker2.run();




    }
}
