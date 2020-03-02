package com.ttan.arraySort;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月13日 下午3:23:59
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 1, 8, 7, 4, 9, 0, 12, 3 };

		for (int d = arr.length / 2; d > 0; d /= 2) {

			for (int i = d; i < arr.length; i++) {

				for (int j = i - d; j >= 0; j -= d) {

					if (arr[j] > arr[j + d]) {
						int temp = arr[j];
						arr[j] = arr[j + d];
						arr[j + d] = temp;
					}
				}
			}
			System.out.println(d);
			System.out.println(Arrays.toString(arr));
		}
	}
}
