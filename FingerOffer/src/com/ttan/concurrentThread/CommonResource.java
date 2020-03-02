package com.ttan.concurrentThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 
 * @author ttan
 * @time 2019��11��19�� ����7:34:51
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
                    System.out.println("�������ݣ��ȴ���������");
                    producer_con.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("����������������");
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
                    System.out.println("û�������ˣ��ȴ���������������");
                    consumer_con.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println("��������������");
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
