package com.ttan.concurrentThread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 
 * @author ttan
 * @time 2019��10��29�� ����4:55:25
 */
public class TestCountDownLatch {
	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(10);
		LatchDemo ld = new LatchDemo(latch);

		long start = System.currentTimeMillis();

		// ����10���߳�
		for (int i = 0; i < 10; i++) {
			new Thread(ld).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {

		}

		long end = System.currentTimeMillis();

		System.out.println("�ķ�ʱ��Ϊ:" + (end - start));

	}
}

class LatchDemo implements Runnable {
	private CountDownLatch latch;

	// �вι�����
	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {

		synchronized (this) {
			try {
				// ��ӡ50000���ڵ�ż��
				for (int i = 0; i < 500; i++) {
					if (i % 2 == 0) {
						System.out.println(i);
					}
				}
			} finally {
				// �߳������ݼ�
				latch.countDown();
			}
		}
	}
}
