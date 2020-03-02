package com.ttan.numMath;

import java.util.ArrayList;

/**
 * @Description: 和为S的两个数字
 * @author ttan
 * @time 2019年7月9日 下午4:23:54
 */
public class FindNumbersWithSum {

	/*输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。*/

	// 对应每个测试案例，输出两个数，小的先输出。

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
