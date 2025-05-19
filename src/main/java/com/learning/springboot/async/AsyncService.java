package com.learning.springboot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void asyncPrint() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Current Thread in asyncMethod "+Thread.currentThread().getName());
    }
}
