package com.ttan.numMath;

import java.util.ArrayList;

/**
 * @Description: ��ΪS��������������
 * @author ttan
 * @time 2019��7��9�� ����4:03:12
 */
public class FindContinuousSequence {
	/* С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
	 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
	 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
	 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? 
	 * Good Luck!*/

	// ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (sum < 3) {
			return result;
		}
		// ������߽���ұ߽�
		int left = 1;
		int right = 2;
		while (left < right) {
			int gosTemp = (left + right) * (right - left + 1) / 2;
			if (gosTemp == sum) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int i = left; i <= right; i++) {
					list.add(i);
				}
				result.add(list);
				left++;
			} else if (gosTemp < sum) {
				right++;
			} else {
				left++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new FindContinuousSequence().FindContinuousSequence(1000));
	}
}
