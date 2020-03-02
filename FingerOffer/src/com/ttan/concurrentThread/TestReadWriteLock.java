package com.ttan.concurrentThread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 
 * @author ttan
 * @time 2019��10��29�� ����5:19:38
 */
public class TestReadWriteLock {

	public static void main(String[] args){
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        // һ���߳̽���д
        new Thread(new Runnable(){
            public void run(){
                rw.set((int)(Math.random()*100));
            }
        },"Write:").start();

        // 100���߳̽��ж�����
        for(int i=0; i<10; i++){
            new Thread(new Runnable(){
                public void run(){
                    rw.get();
                }
            },"Read:").start();
        }
    }

}

class ReadWriteLockDemo{
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // ��
    public void get(){
        lock.readLock().lock(); // ����

        try{
            System.out.println(Thread.currentThread().getName()+"read:"+number);
        }finally{
            lock.readLock().unlock(); // �ͷ���
        }
    }

    // д
    public void set(int number){

        lock.writeLock().lock();

        try{    
            System.out.println(Thread.currentThread().getName()+"writer:"+number);

            this.number = number;
        }finally{
            lock.writeLock().unlock();
        }
    }
}
