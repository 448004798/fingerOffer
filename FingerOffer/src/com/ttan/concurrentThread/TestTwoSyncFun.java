package com.ttan.concurrentThread;

/**
 * @Description: 
 * @author ttan
 * @time 2019年10月30日 上午10:45:17
 */
public class TestTwoSyncFun {

	synchronized void m1() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m1 end");
	}

	synchronized void m2() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("m2 end");
	}

	public static void main(String[] args) throws InterruptedException {
		TestTwoSyncFun t = new TestTwoSyncFun();
		new Thread(() -> {
			t.m1();
		}).start();
		new Thread(() -> {
			t.m2();
		}).start();
	}
}
