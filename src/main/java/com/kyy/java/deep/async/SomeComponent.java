package com.kyy.java.deep.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeComponent {
    public static final int TOTAL_CNT = 10000;
    private final AsyncService asyncService;

    static int number = 0;

    @Autowired
    public SomeComponent(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    public void performTask() {
        asyncService.executeAsyncTask(() -> {
            // 여기에 비동기로 실행할 작업을 넣습니다.
            for (int i = 0; i < TOTAL_CNT; i++) {
                number += i;
            }
            System.out.println(String.format("before number: %d", number));
        });

        asyncService.executeAsyncTask(() -> {
            // 여기에 비동기로 실행할 작업을 넣습니다.
            for (int i = 0; i < 10000; i++) {
                number -= i;
            }
            System.out.println(String.format("next number: %d", number));
        });
    }

    public static void main(String[] args) {
        SomeComponent someComponent = new SomeComponent(new AsyncService());
        someComponent.performTask();
    }
}
