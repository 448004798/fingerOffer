package com.ttan.string;

/**
 * @Description: 左旋转字符串
 * @author ttan
 * @time 2019年7月10日 下午2:29:11
 */
public class LeftRotateString {

	/*汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
	 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
	 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
	 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
	*/

	/**
	* 思路：
	* 1.先翻转前半部分  得到cbaXYZdef
	* 2.再翻转后半部分          cbafedZYX
	* 3.再对字符串整个进行翻转 XYZdefabc
	*
	* 考点：不使用库对字符串进行灵活的翻转
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
