package com.ttan.dynamicProgramming;

/**
 * @Description: ��̬��̨��
 * @author ttan
 * @time 2019��6��20�� ����2:40:03
 */
public class JumpFloorII {

	/* һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж����������� */
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
		 * �����⣺
		 * 
		 * ��Ϊn��̨�ף���һ����n����������1������2��������n�� ��1����ʣ��n-1������ʣ��������f(n-1)
		 * ��2����ʣ��n-2������ʣ��������f(n-2) ����f(n)=f(n-1)+f(n-2)+...+f(1)
		 * ��Ϊf(n-1)=f(n-2)+f(n-3)+...+f(1) ����f(n)=2*f(n-1)
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
