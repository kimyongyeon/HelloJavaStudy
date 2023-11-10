package com.kyy.java.chapter01;

public class Member {
    public int id;

    void print() {
        Car.name = "hell Car";
        Car car = new Car();
        car.age = 1;
        Car car1 = new Car();
        car1.age = 2;
        Car car2 = new Car();
        car2.age = 3;
        Car car3 = new Car();
        car3.age = 4;
        Car car4 = new Car();
        car4.age = 5;
        System.out.println("Member");
    }
}
