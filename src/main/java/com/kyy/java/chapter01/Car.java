package com.kyy.java.chapter01;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {

    static String name = "홍길동";
    int age = 123;

    static int seq = 1;

    static AtomicInteger atomicInteger = new AtomicInteger(1);

    int minusSeq() {
        atomicInteger.addAndGet(-1);
        return seq--;
    }

    int getSeq() {
        atomicInteger.addAndGet(1);
        return seq++;
    }

    public Car() {
        Member member1 = new Member();
        member1.id = getSeq(); // 1
        Member member2 = new Member();
        member2.id = getSeq(); // 2
        Member member3 = new Member();
        member3.id = getSeq(); // 3
        Member member4 = new Member();
        member4.id = getSeq(); // 4
        System.out.println(String.format("member1.id: %d", member1.id));
        System.out.println(String.format("member2.id: %d", member2.id));
        System.out.println(String.format("member3.id: %d", member3.id));
        System.out.println(String.format("member4.id: %d", member4.id));
    }

    public void run(String run) {
        System.out.println(run);
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.run("run");
        Car2 car2 = new Car2();
    }

}

