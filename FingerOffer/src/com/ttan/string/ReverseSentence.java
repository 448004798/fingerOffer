package com.ttan.string;

/**
 * @Description: 翻转单词顺序列
 * @author ttan
 * @time 2019年7月10日 下午3:03:32
 */
public class ReverseSentence {

	/*牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
	 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
	 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
	 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
	 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？*/

	public String ReverseSentence(String str) {

		if (str == null || "".equals(str.trim())) {
			return str;
		}
		// 利用api解
		// String[] strArray = str.split(" ");
		// StringBuilder sbd = new StringBuilder();
		// for (int i = strArray.length - 1; i >= 0; i--) {
		// sbd.append(strArray[i]);
		// sbd.append(" ");
		// }
		// sbd.deleteCharAt(sbd.length() - 1);
		// return sbd.toString();

		// 翻转字符串来解
		char[] ch = str.toCharArray();
		// 全部翻转过来
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
