package com.kyy.java.chapter04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainCalc {

    public static int calcu(CalcInter calcInter) {
        return calcInter.operation(1, 2);
    }

    public static boolean checkMember(MemberService memberService) {
        return memberService.checkMember("id", "password");
    }

    public void generatorLotto() {

    }

    public static void main(String[] args) {

        List list = List.of(1, 2, 3, 4, 5); // 초기화 + 선언
        List<String> list2 = List.of("1", "2", "3", "4", "5"); // 초기화 + 선언
        List<String> list3 = new ArrayList<>(); // 초기화
        List<String> list4;

//        list2.add("123123");

        // repository
        list3.add("123123");
        list3.remove(0);
        list3.set(0, "123123");
        list3.get(0);

        // service
        // createProduct(); -> repository.save();

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(10);

        set.remove(10);


        calcu((a, b) -> a + b);
        calcu((a, b) -> a - b);
        calcu((a, b) -> a / b);
        calcu((a, b) -> a * b);

        checkMember((id, password) -> id.equals("id") && password.equals("password"));
    }
}
