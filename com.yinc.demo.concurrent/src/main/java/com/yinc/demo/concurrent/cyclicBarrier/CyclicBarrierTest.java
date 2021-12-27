package com.yinc.demo.concurrent.cyclicBarrier;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    static Queue<String> queue01 = new ArrayDeque<>();

    static Queue<String> queue02= new ArrayDeque<>();

    public static void main(String[] args) {

        //汇总线程
        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"开始消费；"+queue01.poll()+";"+queue02.poll());

        }, "work-03");

        CyclicBarrier cyc = new CyclicBarrier(2,thread3);

        //工作线程1
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                    queue01.add(Thread.currentThread().getName()+"存入");
                    cyc.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        },"work-01").start();
        //工作线程2
        new Thread(()->{
            while (true){
            try {
                Thread.sleep(1000);
                queue02.add(Thread.currentThread().getName()+"存入");
                cyc.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            }
        },"work-02").start();


        while (true){

        }

    }
}
