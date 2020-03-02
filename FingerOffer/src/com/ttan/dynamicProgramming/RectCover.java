package com.ttan.dynamicProgramming;

/**
 * @Description: 矩形覆盖
 * @author ttan
 * @time 2019年6月20日 下午3:04:13
 */
public class RectCover {

	/* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？ */
	public int RectCover(int target) {
		if (target <= 2) {
			return target;
		}

		return RectCover(target - 1) + RectCover(target - 2);
	}
}
