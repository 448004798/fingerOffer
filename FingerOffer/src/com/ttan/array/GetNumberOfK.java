package com.ttan.array;

/**
 * @Description: ���������������г��ֵĴ���
 * @author ttan
 * @time 2019��7��5�� ����4:13:27
 */
public class GetNumberOfK {

	/*ͳ��һ�����������������г��ֵĴ�����*/

	public int GetNumberOfK(int[] array, int k) {

		if (array == null || array.length == 0) {
			return 0;
		}
		int firstIndex = getFirstIndex(array, k, 0, array.length - 1);
		int lastIndex = getLastIndex(array, k, 0, array.length - 1);
		if (firstIndex != -1 && lastIndex != -1) {
			return lastIndex - firstIndex + 1;
		}
		return 0;
	}

	public int getFirstIndex(int[] array, int k, int start, int end) {

		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (array[mid] > k) {
			return getFirstIndex(array, k, start, mid - 1);
		} else if (array[mid] < k) {
			return getFirstIndex(array, k, mid + 1, end);
		} else if (mid - 1 >= 0 && array[mid - 1] == k) {
			return getFirstIndex(array, k, start, mid - 1);
		} else {
			return mid;
		}

	}

	public int getLastIndex(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (array[mid] > k) {
			return getLastIndex(array, k, start, mid - 1);
		} else if (array[mid] < k) {
			return getLastIndex(array, k, mid + 1, end);
		} else if (mid + 1 < array.length && array[mid + 1] == k) {
			return getLastIndex(array, k, mid + 1, end);
		} else {
			return mid;
		}
	}
}
