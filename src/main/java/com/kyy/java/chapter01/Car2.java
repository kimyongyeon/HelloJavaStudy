package com.kyy.java.chapter01;

public class Car2 {
    public Car2() {
        Car car = new Car();
        Member member1 = new Member();
        member1.id = car.minusSeq(); // 1
        Member member2 = new Member();
        member2.id = car.getSeq(); // 2
        Member member3 = new Member();
        member3.id = car.getSeq(); // 3
        Member member4 = new Member();
        member4.id = car.minusSeq(); // 4
        System.out.println(String.format("member1.id: %d", member1.id));
        System.out.println(String.format("member2.id: %d", member2.id));
        System.out.println(String.format("member3.id: %d", member3.id));
        System.out.println(String.format("member4.id: %d", member4.id));
    }
}
