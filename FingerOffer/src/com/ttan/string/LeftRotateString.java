package com.ttan.string;

/**
 * @Description: ����ת�ַ���
 * @author ttan
 * @time 2019��7��10�� ����2:29:11
 */
public class LeftRotateString {

	/*�����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
	 * �������ַ���ģ�����ָ���������������һ���������ַ�����S��
	 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,
	 * Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
	*/

	/**
	* ˼·��
	* 1.�ȷ�תǰ�벿��  �õ�cbaXYZdef
	* 2.�ٷ�ת��벿��          cbafedZYX
	* 3.�ٶ��ַ����������з�ת XYZdefabc
	*
	* ���㣺��ʹ�ÿ���ַ����������ķ�ת
	*/
	public String LeftRotateString(String str, int n) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		char[] chars = str.toCharArray();
		int len = chars.length;
		n = n % len;

		reverse(chars, 0, n - 1);
		reverse(chars, n, len - 1);
		reverse(chars, 0, len - 1);

		return new String(chars);
	}

	public void reverse(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.println(new LeftRotateString().LeftRotateString("abcXYZdef", 3));
	}
}
