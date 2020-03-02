package com.ttan.concurrentThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 
 * @author ttan
 * @time 2019��10��29�� ����5:16:48
 */
public class TestLock {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();

		new Thread(ticket, "1�Ŵ���").start();
		new Thread(ticket, "2�Ŵ���").start();
		new Thread(ticket, "3�Ŵ���").start();
	}
}

/*class Ticket implements Runnable {

	private int tick = 100;

	public void run() {
		while (true) {
			if (tick > 0) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {

				}

				System.out.println(Thread.currentThread().getName() + "�����Ʊ,��ƱΪ: " + --tick);
			}
		}
	}
}*/

class Ticket implements Runnable{

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    public void run(){
        while(true){
            // ����
            lock.lock();

            try{
                if(tick > 0){
                    try{
                        Thread.sleep(200);
                    }catch(InterruptedException e){

                    }
                    System.out.println(Thread.currentThread().getName()+"�����Ʊ,��ƱΪ: "+ --tick);
                }
            }finally{
                // �ͷ���
                lock.unlock();
            }
        }
    }
}
