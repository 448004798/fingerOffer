package com.ttan.numMath;

/**
 * @Description: ��������1�ĸ���
 * @author ttan
 * @time 2019��6��20�� ����3:23:47
 */
public class NumberOf1 {

	/* ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ�� */
	
	public int NumberOf1(int n) {
		int result = 0;
		while (n != 0) {

			result++;
			n = n & n - 1;
		}
		return result;
	}
}
