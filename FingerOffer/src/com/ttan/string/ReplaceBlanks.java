package com.ttan.string;

/**
 * @Description: �滻�ո�
 * @author ttan
 * @time 2019��6��15�� ����3:56:34
 */
public class ReplaceBlanks {

	/*
	 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are
	 * Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
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
