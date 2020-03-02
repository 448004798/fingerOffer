package com.ttan.numMath;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月27日 下午3:56:52
 */
import java.util.ArrayList;

public class MinNumberInRotateArray {
	public static int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}

		for (int i = 0, len = array.length; i < len - 1; i++) {

			if (array[i] > array[i + 1]) {
				return array[i + 1];
			} else {
				if (i == len - 2) {
					return array[0];
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[] { 6, 7, 4, 5, 1, 2, 3 }));
	}
}