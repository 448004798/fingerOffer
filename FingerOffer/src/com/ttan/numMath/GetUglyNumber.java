package com.ttan.numMath;

/**
 * @Description: 丑数
 * @author ttan
 * @time 2019年7月2日 上午10:08:02
 */
public class GetUglyNumber {

	/* 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
	 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
	 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
	 */

	public int GetUglyNumber_Solution(int index) {

		// 丑数能够分解成2^x3^y5^z
		// 在2x，3y，5z中，如果x=y=z那么最小丑数一定是乘以2的，但关键是有可能存在x》y》z的情况，
		// 所以我们要维持三个指针来记录当前乘以2、乘以3、乘以5的最小值，然后当其被选为新的最小值后，要把相应的指针+1；
		// 因为这个指针会逐渐遍历整个数组，因此最终数组中的每一个值都会被乘以2、乘以3、乘以5，
		// 也就是实现了我们最开始的想法，只不过不是同时成乘以2、3、5，而是在需要的时候乘以2、3、5
		if (index < 7)
			return index;

		int[] res = new int[index];
		res[0] = 1;
		int t2 = 0, t3 = 0, t5 = 0;

		for (int i = 1; i < index; i++) {
			res[i] = min(min(res[t2] * 2, res[t3] * 3), res[t5] * 5);
			if (res[i] == res[t2] * 2)
				t2++;
			if (res[i] == res[t3] * 3)
				t3++;
			if (res[i] == res[t5] * 5)
				t5++;
		}
		return res[index - 1];
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}
}
