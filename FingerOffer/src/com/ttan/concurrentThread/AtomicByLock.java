package com.ttan.concurrentThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicByLock {

	private int value;
	private Lock lock = new ReentrantLock();

	public AtomicByLock(int value) {
		super();
		this.value = value;
	}

	public final int get() {
		lock.lock();
		try {
			return value;
		} finally {
			lock.unlock();
		}
	}

	public final int incrementAndGet() {
		lock.lock();
		try {
			return ++value;
		} finally {
			lock.unlock();
		}
	}
	
	static int staticValue = 0;
	
	public static void main(String[] args) throws InterruptedException {
		final int max = 10;
	     final int loopCount = 100000;
	     long costTime = 0;
	     for (int m = 0; m < max; m++) {
	         long start1 = System.nanoTime();
	         final AtomicByLock value1 = new AtomicByLock(0);
	         Thread[] ts = new Thread[max];
	         for(int i=0;i<max;i++) {
	             ts[i] = new Thread() {
	                 public void run() {
	                     for (int i = 0; i < loopCount; i++) {
	                         value1.incrementAndGet();
	                     }
	                 }
	             };
	         }
	         for(Thread t:ts) {
	             t.start();
	         }
	         for(Thread t:ts) {
	             t.join();
	         }
	         long end1 = System.nanoTime();
	         costTime += (end1-start1);
	     }
	     System.out.println("cost1: " + (costTime));
	     costTime = 0;

	     final Object lock = new Object();
	     for (int m = 0; m < max; m++) {
	         staticValue=0;
	         long start1 = System.nanoTime();
	         Thread[] ts = new Thread[max];
	         for(int i=0;i<max;i++) {
	             ts[i] = new Thread() {
	                 public void run() {
	                     for (int i = 0; i < loopCount; i++) {
	                         synchronized(lock) {
	                             ++staticValue;
	                         }
	                     }
	                 }
	             };
	         }
	         for(Thread t:ts) {
	             t.start();
	         }
	         for(Thread t:ts) {
	             t.join();
	         }
	         long end1 = System.nanoTime();
	         costTime += (end1-start1);
	     }
	     System.out.println("cost2: " + (costTime));
	}
}
