package com.yinc.demo.concurrent.CompletionService;

import java.util.concurrent.*;

public class CompletionServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建线程池
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
// 创建 CompletionService
        CompletionService<String> cs = new
                ExecutorCompletionService<>(executor);

        cs.submit(() -> {
            try {
                System.out.println("当前数据为i：" + 1 + "冷却时间r:" + 5);
                TimeUnit.SECONDS.sleep(5);
                return "数据" + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        cs.submit(() -> {
            try {
                System.out.println("当前数据为i：" + 2 + "冷却时间r:" + 3);
                TimeUnit.SECONDS.sleep(3);
                return "数据" + 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
        cs.submit(() -> {
            try {
                System.out.println("当前数据为i：" + 3 + "冷却时间r:" + 10);
                TimeUnit.SECONDS.sleep(10);
                return "数据" + 3;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        for (int i=0; i<3; i++) {
            System.out.println(cs.take().get());
        }
    }
}
