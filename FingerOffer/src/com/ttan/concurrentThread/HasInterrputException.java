package com.ttan.concurrentThread;

/**
 * @Description: 
 * @author ttan
 * @time 2019��11��15�� ����2:44:24
 */
/**
 *��˵���������������׳�InterruptedException�쳣�������Ҫ�����жϣ���Ҫ�ֶ����ж�һ��
 */
public class HasInterrputException {

	private static class UseThread extends Thread{

		public UseThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			while(!isInterrupted()) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName()
							+" in InterruptedException interrupt flag is "
							+isInterrupted());
					//��Դ�ͷ�
//					interrupt();
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ " I am extends Thread.");
			}
			System.out.println(Thread.currentThread().getName()
					+" interrupt flag is "+isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("HasInterrputEx");
		endThread.start();
		Thread.sleep(1000);
		endThread.interrupt();//�ж��̣߳���ʵ�����̵߳ı�ʶλtrue
	}
}


