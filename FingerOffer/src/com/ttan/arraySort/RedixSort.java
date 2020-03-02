package com.ttan.arraySort;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月13日 下午4:54:42
 */
public class RedixSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 15, 59, 676, 228, 21, 4, 47, 72, 93, 335, 26, 70 };

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = String.valueOf(max).length();

		int[][] temp = new int[10][arr.length];
		int[] counts = new int[10];

		for (int j = 0, n = 1; j < maxLength; j++, n *= 10) {

			for (int k = 0; k < arr.length; k++) {

				int remainder = arr[k] / n % 10;
				temp[remainder][counts[remainder]++] = arr[k];

			}
			int index = 0;

			for (int l = 0; l < counts.length; l++) {
				if (counts[l] != 0) {

					for (int x = 0; x < counts[l]; x++) {
						arr[index++] = temp[l][x];
					}
					counts[l] = 0;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
