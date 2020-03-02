package com.ttan.string;

/**
 * @Description: 替换空格
 * @author ttan
 * @time 2019年6月15日 下午3:56:34
 */
public class ReplaceBlanks {

	/*
	 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are
	 * Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 */
	public String replaceSpace(StringBuffer str) {

		String replaceString = "%20";
		int blankIndex = str.indexOf(" ");
		while (blankIndex != -1) {
			str.replace(blankIndex, blankIndex + 1, replaceString);
			blankIndex = str.indexOf(" ");
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ReplaceBlanks().replaceSpace(new StringBuffer("We Are Happy")));
	}
}
