package com.ttan.dynamicProgramming;

/**
 * @Description: ���θ���
 * @author ttan
 * @time 2019��6��20�� ����3:04:13
 */
public class RectCover {

	/* ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ����� */
	public int RectCover(int target) {
		if (target <= 2) {
			return target;
		}

		return RectCover(target - 1) + RectCover(target - 2);
	}
}
