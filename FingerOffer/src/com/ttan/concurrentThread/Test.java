package com.ttan.concurrentThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void add() {
        while(num<100) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ":" + num++);
                condition.signal();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
    
    public static void main(String[] args) {
    	 Test test=new Test();
         new Thread(() -> {
             test.add();
         }).start();

         new Thread(() -> {
             test.add();
         }).start();
	}
}