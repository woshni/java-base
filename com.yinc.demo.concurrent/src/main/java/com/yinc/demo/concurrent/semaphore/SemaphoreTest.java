package com.yinc.demo.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量工具使用
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        semaphore.acquire();
        Thread thread = new Thread(() -> {
            System.out.println("进入线程1");
            try {
                semaphore.acquire();
                System.out.println("业务处理");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        thread.start();
        thread.join();
        //互相等待，类似死锁
        //释放
        semaphore.release();
    }
}
