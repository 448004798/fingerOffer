package com.ttan.numMath;

/**
 * @Description: ��ֵ�������η�
 * @author ttan
 * @time 2019��6��20�� ����3:29:25
 */
public class Power {

	/* ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η��� */

	public double Power(double base, int exponent) {

		int n = exponent;

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			// exponent < 0
			if (base == 0) {
				// ��ĸ����Ϊ0
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
