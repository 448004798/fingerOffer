package com.ttan.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description:字符串的排列
 * @author ttan
 * @time 2019年6月25日 下午2:11:39
 */
public class Permutation {

	/*
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,
	 * bac,bca,cab和cba。
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
