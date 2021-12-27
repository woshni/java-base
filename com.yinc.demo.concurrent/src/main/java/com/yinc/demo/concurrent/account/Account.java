package com.yinc.demo.concurrent.account;

public class Account {

    private static final Allocator ALLOCATOR = new Allocator();

    // 锁：保护账户余额
    private final Object balLock
            = new Object();

    // 账户余额
    private Integer balance;

    // 锁：保护账户密码
    private final Object pwLock
            = new Object();

    // 账户密码
    private String password;

    public Account(Integer balance) {
        this.balance = balance;
    }

    // 取款
    void withdraw(Integer amt) {
        synchronized (balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 查看余额
    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }

    // 查看密码
    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }

    // 转账
    void transfer(
            Account target, int amt) {
        ALLOCATOR.apply(this,target);

        try {

        synchronized (this){
            synchronized (target){
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
        }finally {
            ALLOCATOR.free(this,target);
        }

    }
}
