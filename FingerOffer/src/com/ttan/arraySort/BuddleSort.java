package com.ttan.arraySort;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2019��12��13�� ����2:00:45
 */
public class BuddleSort {

	public static void main(String[] args) {

		int[] array = { 5, 2, 6, 1, 8, 7, 4, 9, 0, 12, 3 };

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {

					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

}
