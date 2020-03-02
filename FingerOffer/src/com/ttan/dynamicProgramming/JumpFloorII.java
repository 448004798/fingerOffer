package com.ttan.dynamicProgramming;

/**
 * @Description: 变态跳台阶
 * @author ttan
 * @time 2019年6月20日 下午2:40:03
 */
public class JumpFloorII {

	/* 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。 */
	public int JumpFloorII(int target) {

		if (target == 0 || target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int result = 0;
		for (int i = 1; i <= target; i++) {
			result += JumpFloorII(target - i);
		}
		return result;

		/**
		 * 其他解：
		 * 
		 * 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级 跳1级，剩下n-1级，则剩下跳法是f(n-1)
		 * 跳2级，剩下n-2级，则剩下跳法是f(n-2) 所以f(n)=f(n-1)+f(n-2)+...+f(1)
		 * 因为f(n-1)=f(n-2)+f(n-3)+...+f(1) 所以f(n)=2*f(n-1)
		 * 
		 * 
		 * if(target <= 2)
         *   return target;
         * else
         *   return JumpFloorII(target - 1) * 2;
		 */
	}

	public static void main(String[] args) {
		System.out.println(new JumpFloorII().JumpFloorII(3));
	}
}
