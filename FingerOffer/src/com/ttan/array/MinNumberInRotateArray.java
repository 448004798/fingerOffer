package com.ttan.array;

/**
 * @Description: ��ת�������С����
 * @author ttan
 * @time 2019��6��20�� ����2:15:30
 */
public class MinNumberInRotateArray {

	/*
	 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
	 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
	 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
	 */
	public int minNumberInRotateArray(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1 || array.length == 2) {
			return array[0];
		}

		for (int i = 0, len = array.length; i < len; i++) {

			if (array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
		return 0;
	}

	public static void main(String[] args) {

	}
}
