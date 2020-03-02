package com.ttan.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Description: 第一个只出现一次的字符
 * @author ttan
 * @time 2019年7月3日 下午2:27:57
 */
public class FirstNotRepeatingChar {

	/*在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符
	 * ,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
	 */

	public int FirstNotRepeatingChar(String str) {

		if (str == null || "".equals(str)) {
			return -1;
		}

		int[] counts = new int[256];
		// //用一个类似hash的东西来存储字符出现的次数
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
