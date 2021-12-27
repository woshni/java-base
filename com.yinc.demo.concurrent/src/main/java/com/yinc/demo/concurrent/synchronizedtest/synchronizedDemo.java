package com.yinc.demo.concurrent.synchronizedtest;

public class synchronizedDemo {
    public static void main(String[] args) throws InterruptedException {

        synchronizedDemo lock = new synchronizedDemo();
        final Integer[] iii = {new Integer(0)};
        Thread thread1 = new Thread("线程1") {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(getName() + "线程启动了");
                    try {
                        while (iii[0] ==0){
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "线程结束了");
                }

            }
        };


        Thread thread2 = new Thread("线程2") {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(getName() + "线程启动了");
                    lock.notify();
                    System.out.println(getName() + "线程结束了");
                }

            }
        };



        Thread thread3 = new Thread("线程3") {
            @Override
            public void run() {
                synchronized (lock) {
                    iii[0] =new Integer(1);
                    System.out.println(getName() + "线程启动了");
                    System.out.println(getName() + "线程结束了");
                }

            }
        };


        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

    }
}
