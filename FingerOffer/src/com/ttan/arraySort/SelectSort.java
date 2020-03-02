package com.ttan.arraySort;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月13日 下午4:24:45
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 1, 8, 7, 4, 9, 0, 12, 3 };

		for (int i = 0; i < arr.length; i++) {

			int minIndex = i;
			for (int j = i; j < arr.length; j++) {

				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
