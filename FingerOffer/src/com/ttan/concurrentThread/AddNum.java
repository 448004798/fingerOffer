package com.ttan.concurrentThread;

/**
 * @Description: 
 * @author ttan
 * @time 2019��11��15�� ����4:08:50
 */
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class AddNum extends RecursiveTask<Integer> {
	private int startNum;
	private int endNum;
	private int splitNum;

	public AddNum(int startNum, int endNum, int splitNum) {
		this.startNum = startNum;
		this.endNum = endNum;
		this.splitNum = splitNum;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// �ж������Ƿ���Ҫ���
		if (this.endNum - this.startNum <= this.splitNum) {
			for (int i = this.startNum; i <= this.endNum; i++) {
				// ģ��ҵ�����ִ��
				"123,456,123,123,123,123".split(",");
				sum += i;
			}
			return sum;
		} else {
			// ���������֣�ʹ��2�ֲ�֣���ȻҲ���Բ����Ȳ��
			int middleNum = (this.startNum + this.endNum) / 2;
			AddNum addLeft = new AddNum(this.startNum, middleNum, this.splitNum);
			AddNum addRight = new AddNum(middleNum + 1, this.endNum, this.splitNum);
			addLeft.fork();// ����ֵ�������뵽�������
			addRight.fork();// ����ֵ�������뵽�������
			//invokeAll(addLeft, addRight);
			return addLeft.join() + addRight.join(); // ִ��compute���������ص���������ʱ���ִ�н��
		}
	}

	private static int SPLIT_NUM = 100;
	private static int END_NUM = 1000000;
	private static int START_NUM = 0;

	public static void main(String[] args) {
		long bdate = System.currentTimeMillis();
		int sum = 0;
		for (int i = START_NUM; i <= END_NUM; i++) {
			// ģ��ҵ�����ִ��
			"123,456,123,123,123,123".split(",");
			sum += i;
		}
		System.out.println("��ͨѭ�����===>" + sum + "  �ķ�ʱ��===>" + (System.currentTimeMillis() - bdate));
		bdate = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		AddNum addNum = new AddNum(START_NUM, END_NUM, SPLIT_NUM);
		int result = forkJoinPool.invoke(addNum);
		System.out.println("forkJoin  ���===>" + result + "  �ķ�ʱ��===>" + (System.currentTimeMillis() - bdate));
	}
}
