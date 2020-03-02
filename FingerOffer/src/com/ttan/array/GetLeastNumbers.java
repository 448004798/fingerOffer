package com.ttan.array;

import java.util.ArrayList;

/**
 * @Description: ��С��K����
 * @author ttan
 * @time 2019��6��25�� ����3:27:46
 */
public class GetLeastNumbers {

	/* ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,�� */

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (input == null || input.length == 0) {
			return result;
		}
		if (k <= 0 || k > input.length) {
			return result;
		}

		quickSort(input, 0, input.length - 1);

		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}

		return result;
	}

	private void quickSort(int[] array, int low, int high) {
		if (low > high) {
			return;
		}
		int i = low;
		int j = high;
		int temp = array[low];

		while (i < j) {
			while (temp <= array[j] && i < j) {
				j--;
			}
			while (temp >= array[i] && i < j) {
				i++;
			}
			if (i < j) {
				int t = array[j];
				array[j] = array[i];
				array[i] = t;
			}
		}

		array[low] = array[i];
		array[i] = temp;

		quickSort(array, low, i - 1);
		quickSort(array, i + 1, high);
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 6, 2, 7, 3, 8 };
		ArrayList<Integer> result = new GetLeastNumbers().GetLeastNumbers_Solution(arr, 4);
		System.out.print(result);
	}
}
