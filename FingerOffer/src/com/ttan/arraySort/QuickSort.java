package com.ttan.arraySort;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月13日 下午2:28:00
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 1, 8, 7, 4, 9, 0, 12, 3 };

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int start, int end) {

		int low = start;
		int high = end;
		if (low >= high) {
			return;
		}

		int stard = arr[low];
		while (low < high) {

			while (low < high && stard <= arr[high]) {
				high--;
			}
			arr[low] = arr[high];

			while (low < high && stard >= arr[low]) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = stard;

		quickSort(arr, start, low - 1);
		quickSort(arr, low + 1, end);
	}

}
