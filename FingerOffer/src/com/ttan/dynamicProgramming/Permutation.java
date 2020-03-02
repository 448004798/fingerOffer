package com.ttan.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description:�ַ���������
 * @author ttan
 * @time 2019��6��25�� ����2:11:39
 */
public class Permutation {

	/*
	 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,
	 * bac,bca,cab��cba��
	 */

	public ArrayList<String> Permutation(String str) {

		ArrayList<String> result = new ArrayList<String>();

		if (str == null || "".equals(str)) {

			return result;
		}
		func(str.toCharArray(), result, 0);
		Collections.sort(result);
		return result;
	}

	private void func(char[] chs, ArrayList<String> list, int index) {
		if (index == chs.length - 1) {
			String str = new String(chs);
			if (!list.contains(str)) {
				list.add(str);
				return;
			}
		} else {
			for (int i = index; i < chs.length; i++) {
				swap(chs, index, i);
				func(chs, list, index + 1);
				swap(chs, index, i);
			}
		}
	}

	private void swap(char[] chs, int i, int j) {
		if (i != j) {
			char temp = chs[i];
			chs[i] = chs[j];
			chs[j] = temp;
		}
	}

	public static void main(String[] args) {

		System.out.println(new Permutation().Permutation("aba"));

	}
}
