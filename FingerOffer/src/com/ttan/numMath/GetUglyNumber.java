package com.ttan.numMath;

/**
 * @Description: ����
 * @author ttan
 * @time 2019��7��2�� ����10:08:02
 */
public class GetUglyNumber {

	/* ��ֻ����������2��3��5��������������Ugly Number����
	 * ����6��8���ǳ�������14���ǣ���Ϊ������������7��
	 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
	 */

	public int GetUglyNumber_Solution(int index) {

		// �����ܹ��ֽ��2^x3^y5^z
		// ��2x��3y��5z�У����x=y=z��ô��С����һ���ǳ���2�ģ����ؼ����п��ܴ���x��y��z�������
		// ��������Ҫά������ָ������¼��ǰ����2������3������5����Сֵ��Ȼ���䱻ѡΪ�µ���Сֵ��Ҫ����Ӧ��ָ��+1��
		// ��Ϊ���ָ����𽥱����������飬������������е�ÿһ��ֵ���ᱻ����2������3������5��
		// Ҳ����ʵ���������ʼ���뷨��ֻ��������ͬʱ�ɳ���2��3��5����������Ҫ��ʱ�����2��3��5
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
