package com.ttan.array;

/**
 * @Description: 调整数组顺序使奇数位于偶数前面
 * @author ttan
 * @time 2019年6月21日 下午2:48:52
 */
public class ReOrderArray {

	/*
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，
	 * 偶数和偶数之间的相对位置不变。
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
