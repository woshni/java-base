package com.yinc.demo.concurrent.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache<K, V> {

    //内存库
    final Map<K, V> data = new HashMap<>();

    //读写锁
    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //读锁
    final Lock readLock = readWriteLock.readLock();

    //写锁
    final Lock writeLock = readWriteLock.writeLock();


    V get(K key) {
        readLock.lock();
        try {
            return data.get(key);
        } finally {
            readLock.unlock();
        }

    }

    V put(K key, V v) {
        writeLock.lock();
        try {
            System.out.println("当前线程持有锁："+Thread.currentThread().getName());
            return data.put(key, v);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Cache{" +
                "data=" + data +
                '}';
    }
}
