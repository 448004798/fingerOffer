package com.ttan.string;

/**
 * @Description: ��ת����˳����
 * @author ttan
 * @time 2019��7��10�� ����3:03:32
 */
public class ReverseSentence {

	/*ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��
	 * дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish����������
	 * ��ȴ������������˼�����磬��student. a am I������������ʶ����
	 * ��һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����
	 * Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��*/

	public String ReverseSentence(String str) {

		if (str == null || "".equals(str.trim())) {
			return str;
		}
		// ����api��
		// String[] strArray = str.split(" ");
		// StringBuilder sbd = new StringBuilder();
		// for (int i = strArray.length - 1; i >= 0; i--) {
		// sbd.append(strArray[i]);
		// sbd.append(" ");
		// }
		// sbd.deleteCharAt(sbd.length() - 1);
		// return sbd.toString();

		// ��ת�ַ�������
		char[] ch = str.toCharArray();
		// ȫ����ת����
		reverse(ch, 0, ch.length - 1);
		int start = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				reverse(ch, start, i - 1);
				start = i + 1;
			}
			if (start >= 0 && i == ch.length - 1) {
				reverse(ch, start, ch.length - 1);
			}
		}
		return new String(ch);
	}

	public void reverse(char[] ch, int start, int end) {
		while (start < end) {
			char temp = ch[start];
			ch[start] = ch[end];
			ch[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.println(new ReverseSentence().ReverseSentence("Is am a student."));
	}
}
