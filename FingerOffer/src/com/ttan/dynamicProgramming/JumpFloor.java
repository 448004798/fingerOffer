package com.ttan.dynamicProgramming;

/**
 * @Description: ��̨��
 * @author ttan
 * @time 2019��6��20�� ����2:35:57
 */
public class JumpFloor {

	/* һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������ */
	public int JumpFloor(int target) {

		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int result = JumpFloor(target - 1) + JumpFloor(target - 2);

		return result;
	}
}
