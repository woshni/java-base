package com.yinc.demo.concurrent.cache;

import java.util.concurrent.CountDownLatch;

public class CacheTest {

    public static void main(String[] args) throws InterruptedException {
        Cache<String, Data> dataCache = new Cache<>();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        String key = "key";
        //多线程并发读写   await(cyclicBarrier);
        Thread thread1 = new Thread(() -> {
            await(countDownLatch);
            Data data = dataCache.put(key, new Data("数据一"));
            System.out.println("thread:" + Thread.currentThread().getName() + "; data:" + data);
        }, "thread----1");

        Thread thread2 = new Thread(() -> {
            await(countDownLatch);
            Data data = dataCache.put(key, new Data("数据二"));
            System.out.println("thread:" + Thread.currentThread().getName() + "; data:" + data);
        }, "thread----2");

        Thread thread3 = new Thread(() -> {
            await(countDownLatch);
            Data data = dataCache.put(key, new Data("数据三"));
            System.out.println("thread:" + Thread.currentThread().getName() + "; data:" + data);
        }, "thread----3");

        Thread thread4 = new Thread(() -> {
            await(countDownLatch);
            Data data = dataCache.put(key, new Data("数据四"));
            System.out.println("thread:" + Thread.currentThread().getName() + "; data:" + data);
        }, "thread----4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        countDownLatch.countDown();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println(dataCache);
    }

    private static void await(CountDownLatch cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
