package com.ttan.dynamicProgramming;

/**
 * @Description: 쳲���������
 * @author ttan
 * @time 2019��6��20�� ����2:28:02
 */
public class Fibonacci {

	/*
	 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0���� n<=39
	 */

	public int Fibonacci(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}

		int result = 0;
		result = Fibonacci(n - 1) + Fibonacci(n - 2);

		return result;
	}
	public static void main(String[] args) {
		
		System.out.println(new Fibonacci().Fibonacci(7));
	}

}
