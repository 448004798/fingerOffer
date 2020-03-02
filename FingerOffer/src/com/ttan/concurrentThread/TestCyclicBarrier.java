package com.ttan.concurrentThread;

import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 
 * @author ttan
 * @time 2019��11��21�� ����2:57:55
 */
public class TestCyclicBarrier {

	// �Զ��幤���߳�
	private static class Worker extends Thread {
		private CyclicBarrier cyclicBarrier;

		public Worker(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			super.run();

			try {
				System.out.println(Thread.currentThread().getName() + "��ʼ�ȴ������߳�");
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName() + "��ʼִ��");
				// �����߳̿�ʼ����������Thread.sleep()��ģ��ҵ����
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "ִ�����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int threadCount = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

		for (int i = 0; i < threadCount; i++) {
			System.out.println("���������߳�" + i);
			Worker worker = new Worker(cyclicBarrier);
			worker.start();
		}
	}
}
//���������߳�0
//���������߳�1
//���������߳�2
//Thread-0��ʼ�ȴ������߳�
//Thread-1��ʼ�ȴ������߳�
//Thread-2��ʼ�ȴ������߳�
//Thread-2��ʼִ��
//Thread-0��ʼִ��
//Thread-1��ʼִ��
//Thread-0ִ�����
//Thread-1ִ�����
//Thread-2ִ�����
