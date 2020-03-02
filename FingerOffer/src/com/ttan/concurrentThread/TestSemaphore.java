package com.ttan.concurrentThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 
 * @author ttan
 * @time 2019��11��21�� ����3:54:58
 */
public class TestSemaphore {

	// 5֧��
	private static Semaphore semaphore = new Semaphore(5, true);

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(10);
		// 10��ѧ��
		for (int i = 0; i < 10; i++) {
			service.execute(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + " ͬѧ��Ҫ�õ���===");
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + " ͬѧ�õ���---");
					System.out.println(Thread.currentThread().getName() + " ͬѧ��д��...");
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName() + " ͬѧ��д��ϣ����Ϲ黹�ʡ�����");
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
