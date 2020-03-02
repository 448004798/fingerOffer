package com.ttan.numMath;

import java.util.Arrays;

/**
 * @Description: �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007
 * @author ttan
 * @time 2020��1��2�� ����2:52:22
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
	 * ���ε�˼�룬�����鲻��һ��Ϊ����ֱ��������ֻ������Ԫ�أ�ͳ������Ը�����
	 * Ȼ������ڵ�������������кϲ��������Ѿ�ͳ�����������������ڲ�������ԣ�
	 * �����Ҫ��������������������򣬱�����֮���ͳ�ƹ������ظ�ͳ�ơ�
	 * �ںϲ���ʱ��ҲҪ������������Ը�����
	 * 
	 * ����Ե����� = ��������е�����Ե����� + �ұ�����������Ե����� + ���ҽ�ϳ��µ�˳������ʱ�г��ֵ�����Ե�����
	 * 
	 * ����������һ���鲢������㷨��
	 * �鲢��������ܲ����������ݵ�Ӱ�죬
	 * ʱ�临�Ӷ�ʼ�ն���O(nlogn)O(nlogn)����������Ҫ������ڴ�ռ䡣
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
				// ���ǰ���Ԫ��С�ں���Ĳ��ܹ��������
				temp[index++] = array[i++];
			} else {
				// ���ǰ���Ԫ�ش��ں���ģ���ô��ǰ��Ԫ��֮���Ԫ�ض��ܺͺ����Ԫ�ع��������
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
