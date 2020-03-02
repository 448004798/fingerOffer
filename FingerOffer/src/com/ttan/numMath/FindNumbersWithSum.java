package com.ttan.numMath;

import java.util.ArrayList;

/**
 * @Description: ��ΪS����������
 * @author ttan
 * @time 2019��7��9�� ����4:23:54
 */
public class FindNumbersWithSum {

	/*����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�*/

	// ��Ӧÿ�����԰����������������С���������

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		int first = 0, last = array.length - 1;

		while (first < last) {
			int firstNum = array[first];
			int lastNum = array[last];
			int sumTemp = firstNum + lastNum;
			if (sumTemp == sum) {
				result.add(firstNum);
				result.add(lastNum);
				return result;
			} else if (sumTemp > sum) {
				last--;
			} else {
				first++;
			}
		}

		return result;
	}
}
