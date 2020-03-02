package com.ttan.concurrentThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 
 * @author ttan
 * @time 2019年11月18日 下午2:18:45
 */
public class CountDownLatchTest {
	
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);
		System.out.println("main thread running....");
		ExecutorService es1 = Executors.newSingleThreadExecutor();
		es1.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" start");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" end");
				latch.countDown();
			}
		});
		es1.shutdown();
		ExecutorService es2 = Executors.newSingleThreadExecutor();
		es2.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" start");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" end");
				latch.countDown();
			}
		});
		es2.shutdown();
		
		System.out.println("wait 2 threads end");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread end");
	}
}
