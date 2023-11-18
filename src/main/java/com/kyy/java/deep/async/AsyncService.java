package com.kyy.java.deep.async;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {
    private final ExecutorService executorService;

    public AsyncService() {
        // 스레드 풀 크기와 작업 큐를 설정합니다.
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        this.executorService = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS, queue);
    }

    public void executeAsyncTask(Runnable task) {
        executorService.execute(task);
    }

    // 애플리케이션이 종료될 때 실행되는 메소드입니다.
    @PreDestroy
    public void destroy() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
