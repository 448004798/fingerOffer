package com.ttan.concurrentThread;

import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 
 * @author ttan
 * @time 2019年11月21日 下午2:57:55
 */
public class TestCyclicBarrier {

	// 自定义工作线程
	private static class Worker extends Thread {
		private CyclicBarrier cyclicBarrier;

		public Worker(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			super.run();

			try {
				System.out.println(Thread.currentThread().getName() + "开始等待其他线程");
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName() + "开始执行");
				// 工作线程开始处理，这里用Thread.sleep()来模拟业务处理
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "执行完毕");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int threadCount = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

		for (int i = 0; i < threadCount; i++) {
			System.out.println("创建工作线程" + i);
			Worker worker = new Worker(cyclicBarrier);
			worker.start();
		}
	}
}
//创建工作线程0
//创建工作线程1
//创建工作线程2
//Thread-0开始等待其他线程
//Thread-1开始等待其他线程
//Thread-2开始等待其他线程
//Thread-2开始执行
//Thread-0开始执行
//Thread-1开始执行
//Thread-0执行完毕
//Thread-1执行完毕
//Thread-2执行完毕
