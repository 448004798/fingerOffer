package com.ttan.array;

/**
 * @Description:�����г��ִ�������һ�������
 * @author ttan
 * @time 2019��6��25�� ����2:47:43
 */
public class MoreThanHalfNum {

	/*
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
	 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
	 */

	public int MoreThanHalfNum_Solution(int[] array) {

		if (array == null || array.length == 0) {
			return 0;
		}
		int len = array.length;

		int result = array[0];
		int times = 1;

		for (int i = 1; i < len; i++) {
			if (times == 0) {
				result = array[i];
				times++;
			} else {
				if (result == array[i]) {
					times++;
				} else {
					times--;
				}
			}
		}

		times = 0;
		for (int i = 0; i < len; i++) {
			if (result == array[i]) {
				times++;
			}
		}

		return times * 2 > len ? result : 0;
	}
}
