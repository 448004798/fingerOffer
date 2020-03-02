package com.ttan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 数组中只出现一次的数字
 * @author ttan
 * @time 2019年7月9日 下午3:45:29
 */
public class FindNumsAppearOnce {

	/*一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。*/

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
