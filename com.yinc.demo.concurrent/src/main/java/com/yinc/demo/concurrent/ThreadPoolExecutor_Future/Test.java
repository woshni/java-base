package com.yinc.demo.concurrent.ThreadPoolExecutor_Future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Test {

    private static volatile  int anInt = 1;

    public static void main(String[] args) throws Throwable {
        //接收返回值
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        //临时存储
        List<Future<String>> result = new ArrayList<>();
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        //执行三个任务
        Random random = new Random(10);
        Future<String> result1 = executorService.submit(() -> {
            try {
                System.out.println("当前数据为i：" + 1 + "冷却时间r:" + 5);
                TimeUnit.SECONDS.sleep(5);
                return "数据" + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        Future<String> result2 = executorService.submit(() -> {
            try {
                System.out.println("当前数据为i：" + 2 + "冷却时间r:" + 7);
                TimeUnit.SECONDS.sleep(7);
                return "数据" + 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        Future<String> result3 = executorService.submit(() -> {
            try {
                int r = random.nextInt(10);
                System.out.println("当前数据为i：" +3 + "冷却时间r:" + 10);
                TimeUnit.SECONDS.sleep(10);
                return "数据" + 3;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        //TimeUnit.SECONDS.sleep(5);

        executorService.execute(()-> {
            try {
                System.out.println(1);
                queue.put(result1.get());
                anInt=1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()-> {
            try {
                anInt=2;
                System.out.println(2);
                queue.put(result2.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.execute(()-> {
            try {
                anInt=3;
                System.out.println(3);
                queue.put(result3.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        //处理结果
        for (int i = 0; i < 3; i++) {
            System.out.println(queue.take());
        }
    }
}
