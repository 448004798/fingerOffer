package com.ttan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ������ֻ����һ�ε�����
 * @author ttan
 * @time 2019��7��9�� ����3:45:29
 */
public class FindNumsAppearOnce {

	/*һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�*/

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0, len = array.length; i < len; i++) {

			int temp = array[i];
			if (list.contains(temp)) {
				list.remove(new Integer(temp));
			} else {
				list.add(temp);
			}
		}

		num1[0] = list.get(0);
		num2[0] = list.get(1);
	}

	public static void main(String[] args) {
		int[] num1 = null;
		int[] num2 = null;
		new FindNumsAppearOnce().FindNumsAppearOnce(new int[] { 2, 4, 3, 6, 3, 2, 5, 5 }, num1, num2);
	}
}
