package com.ttan.array;

/**
 * @Description: ��������˳��ʹ����λ��ż��ǰ��
 * @author ttan
 * @time 2019��6��21�� ����2:48:52
 */
public class ReOrderArray {

	/*
	 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�����֤������������
	 * ż����ż��֮������λ�ò��䡣
	 */

	public void reOrderArray(int[] array) {

		int changeIndex = 0;
		for (int i = 0, size = array.length; i < size; i++) {

			int arrayElement = array[i];
			if (arrayElement % 2 != 0) {
				if (i > changeIndex) {
					for (int j = i; j > changeIndex; j--) {
						array[j] = array[j - 1];
					}
					array[changeIndex] = arrayElement;
				}
				changeIndex++;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 6, 5, 2, 4 };
		for (int a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
		new ReOrderArray().reOrderArray(array);
		for (int a : array) {
			System.out.print(a + " ");
		}
	}
}
