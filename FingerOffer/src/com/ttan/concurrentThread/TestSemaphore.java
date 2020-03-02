package com.ttan.concurrentThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 
 * @author ttan
 * @time 2019年11月21日 下午3:54:58
 */
public class TestSemaphore {

	// 5支笔
	private static Semaphore semaphore = new Semaphore(5, true);

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(10);
		// 10个学生
		for (int i = 0; i < 10; i++) {
			service.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + " 同学想要拿到笔===");
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + " 同学拿到笔---");
					System.out.println(Thread.currentThread().getName() + " 同学填写中...");
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName() + " 同学填写完毕，马上归还笔。。。");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaphore.release();
				}
			});
		}
		service.shutdown();
	}
}
