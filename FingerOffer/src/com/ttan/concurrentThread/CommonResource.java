package com.ttan.concurrentThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 
 * @author ttan
 * @time 2019年11月19日 下午7:34:51
 */
public class CommonResource {
    private boolean isHaveData = false;

    Lock lock = new ReentrantLock();

    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    public void product() {
        lock.lock();
        try {
            while (isHaveData) {
                try {
                    System.out.println("还有数据，等待消费数据");
                    producer_con.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("生产者生产数据了");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isHaveData = true;
            consumer_con.signal();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (!isHaveData) {
                try {
                    System.out.println("没有数据了，等待生产者消费数据");
                    consumer_con.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("消费者消费数据");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isHaveData = false;
            producer_con.signal();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
    	CommonResource resource = new CommonResource();
        new Thread(() -> {
            while (true) {
                resource.product();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                resource.consume();
            }
        }).start();
	}
}
