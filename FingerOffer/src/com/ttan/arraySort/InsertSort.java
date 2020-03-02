package com.ttan.arraySort;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月13日 下午2:58:24
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 1, 8, 7, 4, 9, 0, 12, 3 };

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < arr[i - 1]) {

				int temp = arr[i];
				int j;
				for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
