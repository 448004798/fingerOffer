package com.ttan.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Description: ��һ��ֻ����һ�ε��ַ�
 * @author ttan
 * @time 2019��7��3�� ����2:27:57
 */
public class FirstNotRepeatingChar {

	/*��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�
	 * ,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
	 */

	public int FirstNotRepeatingChar(String str) {

		if (str == null || "".equals(str)) {
			return -1;
		}

		int[] counts = new int[256];
		// //��һ������hash�Ķ������洢�ַ����ֵĴ���
		for (int i = 0; i < str.length(); i++) {
			counts[str.charAt(i)]++;
		}
		for (int j = 0; j < counts.length; j++) {
			if (counts[str.charAt(j)] == 1) {
				return j;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar("googgle"));

	}
}
