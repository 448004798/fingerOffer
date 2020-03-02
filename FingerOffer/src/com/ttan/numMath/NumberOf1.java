package com.ttan.numMath;

/**
 * @Description: 二进制中1的个数
 * @author ttan
 * @time 2019年6月20日 下午3:23:47
 */
public class NumberOf1 {

	/* 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。 */
	
	public int NumberOf1(int n) {
		int result = 0;
		while (n != 0) {

			result++;
			n = n & n - 1;
		}
		return result;
	}
}
