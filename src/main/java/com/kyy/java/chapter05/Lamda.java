package com.kyy.java.chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lamda {

    void multiThread() {

        Callable<String> callable = () -> {
            Thread.sleep(1000);
            System.out.println("callable test");
            return "hello world";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(callable);


        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test1");
        };
        runnable.run();
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test2");
        };
        runnable2.run();
        Runnable runnable3 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test3");
        };
        runnable3.run();
        Runnable runnable4 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test4");
        };
        runnable4.run();
    }


    @FunctionalInterface
    interface SearchApi {
        void test();
    }

    interface SearchApi2 {
        int add(int a, int b);
    }

    public static void main(String[] args) {
        Lamda lamda = new Lamda();
        lamda.multiThread();
//        SearchApi searchApi = () -> System.out.println("test");
//        searchApi = new SearchApi() {
//            @Override
//            public void test() {
//                System.out.println("test");
//            }
//        };
//        searchApi.test();
//
//        SearchApi2 searchApi2 = (a, b) -> a + b;
//        int add = searchApi2.add(1, 2);
//        System.out.println(add);
    }
}
