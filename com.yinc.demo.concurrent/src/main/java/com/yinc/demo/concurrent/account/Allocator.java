package com.yinc.demo.concurrent.account;

import java.util.ArrayList;
import java.util.List;

public class Allocator {

    private final List<Account> als = new ArrayList<>();

    //申请资源
    public synchronized void apply(Account from, Account to) {

        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        als.add(from);
        als.add(to);


    }

    //释放资源
    public synchronized void free(Account from, Account to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }

}
