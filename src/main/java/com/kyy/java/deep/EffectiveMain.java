package com.kyy.java.deep;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class EffectiveMain {

    private static int sharedVariable = 10;
    private static AtomicInteger atomicInteger = new AtomicInteger(10);


    void thread3() {
        Runnable decrementTask = () -> {
            while (true) {
//                int currentValue = atomicInteger.get();
//                if (currentValue > 0) {
//                    atomicInteger.decrementAndGet();
//                    System.out.println(Thread.currentThread().getName() + ": " + currentValue);
//                } else {
//                    break;
//                }
                synchronized (this) {
                    if (sharedVariable > 0) {
                        sharedVariable--;
                        System.out.println(Thread.currentThread().getName() + ": " + sharedVariable);
                    } else {
                        break;
                    }
                }
                try {
                    Thread.sleep(100); // 잠시 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread1 = new Thread(decrementTask, "Thread 1");
        Thread thread2 = new Thread(decrementTask, "Thread 2");

        thread1.start();
        thread2.start();
    }

    static class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                startSignal.await(); // 시작 신호를 기다림
                doWork(); // 실제 작업
                doneSignal.countDown(); // 작업 완료 신호
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        void doWork() {
            System.out.println("Thread " + Thread.currentThread().getId() + " is working");
        }
    }

    static void thread2() throws InterruptedException {
        int threadCount = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; ++i) { // 스레드 생성
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        // 스레드가 준비될 시간을 준다 (필요에 따라)
        Thread.sleep(1000); // 1초 대기

        startSignal.countDown(); // 모든 스레드에 시작 신호를 보냄
        doneSignal.await(); // 모든 스레드가 작업을 완료할 때까지 기다림

        System.out.println("All threads have started and finished their work");
    }

    static void thread1() throws InterruptedException {
        final int threadCount = 5;
        final CountDownLatch latch = new CountDownLatch(threadCount);
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " is running");
                    // 여기에 추가 작업을 넣을 수 있습니다.
                } finally {
                    latch.countDown(); // 작업 완료 후, 카운트 감소
                }
            });
        }

        latch.await(); // 모든 스레드의 작업이 끝날 때까지 기다림
        System.out.println("All threads have finished their tasks");

        executor.shutdown(); // ExecutorService 종료
    }

    public static void main(String[] args) throws InterruptedException {
        EffectiveMain effectiveMain = new EffectiveMain();
        effectiveMain.thread3();
//        thread2();
//        thread1();
//        threadSimple();
    }

    private static void threadSimple() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CountDownLatch countDownLatch = new CountDownLatch(2);

        executorService.execute(() -> {
            countDownLatch.countDown();
            System.out.println("Hello Java Study1");
        });
        executorService.execute(() -> {
            countDownLatch.countDown();
            System.out.println("Hello Java Study2");
        });
        countDownLatch.await();
        executorService.shutdown();
    }
}
