package com.yinc.demo.concurrent.account;

public class AccountTest {

    public static void main(String[] args) throws InterruptedException {
         Account accountA = new Account(100);
         Account accountB = new Account(200);


        for (int i = 0; i < 10; i++) {
            new Thread(() -> accountB.transfer(accountA,10)).start();
            new Thread(() -> accountA.transfer(accountB,10)).start();

        }

        Thread.sleep(5000);
        System.out.println(accountA.getBalance());
        System.out.println(accountB.getBalance());
    }

}
