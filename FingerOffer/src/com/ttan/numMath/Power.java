package com.ttan.numMath;

/**
 * @Description: 数值的整数次方
 * @author ttan
 * @time 2019年6月20日 下午3:29:25
 */
public class Power {

	/* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 */

	public double Power(double base, int exponent) {

		int n = exponent;

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			// exponent < 0
			if (base == 0) {
				// 分母不能为0
			}
			n = -n;
		}
		double result = 1;
		for (int i = 0; i < n; i++) {
			result *= base;
		}
		return exponent >= 0 ? result : 1 / result;
	}

	public static void main(String[] args) {
		System.out.println(new Power().Power(2, -2));
	}
}
