package com.ttan.concurrentThread;

/**
 * @Description: 
 * @author ttan
 * @time 2019年11月15日 下午4:08:50
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
		// 判断任务是否需要拆分
		if (this.endNum - this.startNum <= this.splitNum) {
			for (int i = this.startNum; i <= this.endNum; i++) {
				// 模拟业务代码执行
				"123,456,123,123,123,123".split(",");
				sum += i;
			}
			return sum;
		} else {
			// 进行任务拆分，使用2分拆分，当然也可以不均匀拆分
			int middleNum = (this.startNum + this.endNum) / 2;
			AddNum addLeft = new AddNum(this.startNum, middleNum, this.splitNum);
			AddNum addRight = new AddNum(middleNum + 1, this.endNum, this.splitNum);
			addLeft.fork();// 将拆分的任务加入到任务队列
			addRight.fork();// 将拆分的任务加入到任务队列
			//invokeAll(addLeft, addRight);
			return addLeft.join() + addRight.join(); // 执行compute方法并返回当条件满足时候的执行结果
		}
	}

	private static int SPLIT_NUM = 100;
	private static int END_NUM = 1000000;
	private static int START_NUM = 0;

	public static void main(String[] args) {
		long bdate = System.currentTimeMillis();
		int sum = 0;
		for (int i = START_NUM; i <= END_NUM; i++) {
			// 模拟业务代码执行
			"123,456,123,123,123,123".split(",");
			sum += i;
		}
		System.out.println("普通循环结果===>" + sum + "  耗费时间===>" + (System.currentTimeMillis() - bdate));
		bdate = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		AddNum addNum = new AddNum(START_NUM, END_NUM, SPLIT_NUM);
		int result = forkJoinPool.invoke(addNum);
		System.out.println("forkJoin  结果===>" + result + "  耗费时间===>" + (System.currentTimeMillis() - bdate));
	}
}
