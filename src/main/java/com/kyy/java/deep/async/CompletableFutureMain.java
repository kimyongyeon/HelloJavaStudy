package com.kyy.java.deep.async;

import java.util.concurrent.*;

public class CompletableFutureMain {


    private void threadServiceTest1() {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello1");
        }, executorService);


        // 리턴값이 없는거
        Runnable task = () -> {
            System.out.println("Hello2");
        };
        executorService.execute(task);

        // 리턴값이 있는거
        Callable<String> task2 = () -> {
            System.out.println("Hello3");
            return "Hello3";
        };
        executorService.submit(task2);

        executorService.shutdown();

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hello Java Study");

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Hello2 void");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        future2.get();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1);
                System.out.println("Hello1");
                return "hello world";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        future.thenApply(s -> {
            System.out.println("Hello2");
            return s.toUpperCase();
        }).thenApply(s -> {
            System.out.println("Hello3");
            return s.substring(0, 5);
        }).thenAccept(s -> {
            System.out.println("Hello4");
            System.out.println(s);
        });

//        future.join();
        future.get();


    }
}
