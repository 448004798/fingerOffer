package com.ttan.arraySort;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月13日 下午4:39:38
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 1, 8, 7, 4, 9, 0, 12, 3 };

		merge(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void merge(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int middle = (low + high) / 2;

		merge(arr, low, middle);
		merge(arr, middle + 1, high);
		mergeSort(arr, low, middle, high);
	}

	public static void mergeSort(int[] arr, int low, int middle, int high) {

		int[] temp = new int[high - low + 1];

		int i = low;
		int j = middle + 1;
		int index = 0;
		while (i <= middle && j <= high) {

			if (arr[i] < arr[j]) {
				temp[index++] = arr[i++];
			} else {
				temp[index++] = arr[j++];
			}
		}
		while (i <= middle) {
			temp[index++] = arr[i++];
		}
		while (j <= high) {
			temp[index++] = arr[j++];
		}

		for (int k = 0; k < temp.length; k++) {
			arr[low + k] = temp[k];
		}
	}

}
