package com.ttan.numMath;

import java.util.Arrays;

/**
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author ttan
 * @time 2020年1月2日 下午2:52:22
 */
public class InversePairs {

	public static void main(String[] args) {
		int[] array = new int[] { 364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601,
				650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174,
				557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497,
				82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784,
				3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575 };
		System.out.println(new InversePairs().InversePairs(array));
		System.out.println(Arrays.toString(array));
	}

	static int count = 0;

	public int InversePairs(int[] array) {

		mergeSort(array, 0, array.length - 1);
		return count;
	}

	/**
	 * 分治的思想，将数组不断一分为二，直到数组中只有两个元素，统计逆序对个数。
	 * 然后对相邻的两个子数组进行合并，由于已经统计了这两对子数组内部的逆序对，
	 * 因此需要把这两对子数组进行排序，避免在之后的统计过程中重复统计。
	 * 在合并的时候也要计算组间的逆序对个数。
	 * 
	 * 逆序对的总数 = 左边数组中的逆序对的数量 + 右边数组中逆序对的数量 + 左右结合成新的顺序数组时中出现的逆序对的数量
	 * 
	 * 整个过程是一个归并排序的算法。
	 * 归并排序的性能不受输入数据的影响，
	 * 时间复杂度始终都是O(nlogn)O(nlogn)。代价是需要额外的内存空间。
	 */
	private void mergeSort(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) >> 1;
		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);
		merge(array, low, mid, high);
	}

	private void merge(int[] array, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int index = 0;
		while (i <= mid && j <= high) {
			if (array[i] <= array[j]) {
				// 如果前面的元素小于后面的不能构成逆序对
				temp[index++] = array[i++];
			} else {
				// 如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
				temp[index++] = array[j++];
				count = (count + (mid - i + 1)) % 1000000007;
			}
		}
		while (i <= mid) {
			temp[index++] = array[i++];
		}
		while (j <= high) {
			temp[index++] = array[j++];
		}

		for (int k = 0; k < temp.length; k++) {
			array[low + k] = temp[k];
		}
	}
}
