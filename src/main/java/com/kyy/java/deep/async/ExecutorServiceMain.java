package com.kyy.java.deep.async;

import java.util.concurrent.*;

public class ExecutorServiceMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch latch = new CountDownLatch(2);

        Future<?> hello = executorService.submit(() -> {
            try {
                Thread.sleep(50);
//                System.out.println("Hello1");
                return "hello world";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();
            }
        });

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Hello2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                latch.countDown();
            }
        });

        try {
            latch.await();
            String helloStr = (String) hello.get();
            System.out.println(String.format("helloStr: %s", helloStr));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

    }
}
