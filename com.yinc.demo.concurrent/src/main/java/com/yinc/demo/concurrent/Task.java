package com.yinc.demo.concurrent;

import java.util.Date;

public class Task implements Runnable {
    private Result result;

    public Task(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        result.setStart( new Date());
        System.out.println("开始执行任务");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成");

        result.setEnd( new Date());
    }

    public static void main(String[] args) {
    }
}
