package com.yinc.demo.concurrent.threadpool;

import com.yinc.demo.concurrent.Result;
import com.yinc.demo.concurrent.Task;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor
                = Executors.newFixedThreadPool(2);
        // demoSubmitResult(executor);
        // futureTaskResult(executor);
        // futureTaskCallable(executor);
        //烧水泡茶
        boilWater(executor);

    }

    /**
     * 烧水泡茶
     *
     * @param executor
     */
    private static void boilWater(ExecutorService executor) throws ExecutionException, InterruptedException {
        FutureTask<String> t2 = new FutureTask<String>(() -> {
            System.out.println("t2:---洗茶壶");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("t2:---洗茶杯");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("t2:---拿茶叶");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        });
        FutureTask<Boolean> t1 = new FutureTask<Boolean>(() -> {
            System.out.println("t1:---烧水壶");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("t1:---烧开水");
            TimeUnit.SECONDS.sleep(15);
            System.out.println("t1:---水壶准备就绪");
            String tea = t2.get();
            System.out.println("t1:---拿到茶叶：" + tea);
            System.out.println("t1:---开始泡茶");
            return true;
        });
        executor.execute(t1);
        executor.execute(t2);
        Boolean aBoolean = t1.get();
        System.out.println("main:----喝茶吧---------------");
    }


    /**
     * futureTask 使用 Callable
     *
     * @param executor
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void futureTaskCallable(ExecutorService executor) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask(() -> 1 + 1);

        FutureTask<Integer> futureTask2 = new FutureTask(() -> 1 + 2);

        //线程池执行
        executor.execute(futureTask);
        //启动线程执行
        new Thread(futureTask2).start();
        System.out.println("futureTask  {} " + futureTask.get());
        System.out.println("futureTask2  {} " + futureTask2.get());

    }

    /**
     * futureTask 使用 Result
     *
     * @param executor
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void futureTaskResult(ExecutorService executor) throws ExecutionException, InterruptedException {
        Result result = new Result();

        Result result1 = new Result();

        FutureTask<Result> futureTask = new FutureTask(new Task(result), result1);

        executor.execute(futureTask);

        Result result2 = futureTask.get();
        System.out.println("result   {} " + result);
        System.out.println("result1  {} " + result1);
        System.out.println("result2  {} " + result2);

    }

    /**
     * submit执行一个任务执行传递的参数返回值
     *
     * @param executor
     */
    private void demoSubmitResult(ExecutorService executor) throws ExecutionException, InterruptedException {
        Result result = new Result();
        Future<Result> submit = executor.submit(new Task(result), result);


        result = submit.get();
        System.out.println(result.getStart());
        System.out.println(result.getEnd());
    }
}
