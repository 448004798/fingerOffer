package com.ttan.numMath;

/**
 * @Description: ���������������
 * @author ttan
 * @time 2019��6��25�� ����4:15:39
 */
public class FindGreatestSumOfSubArray {

	/*
	 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
	 * ������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15
	 * ,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(
	 * �������ĳ���������1)
	 */
	public static int findGreatestSumOfSubArray(int[] array) {
		int res = array[0];
		int max = array[0];

		for (int i = 1, len = array.length; i < len; i++) {

			max = max + array[i] > array[i] ? max + array[i] : array[i];
			res = res > max ? res : max;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(findGreatestSumOfSubArray(new int[] { 1, 2, -4, 4, 5 }));
	}
}
