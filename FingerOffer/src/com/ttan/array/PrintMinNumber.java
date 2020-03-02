package com.ttan.array;

/**
 * @Description: 把数组排成最小的数
 * @author ttan
 * @time 2019年6月25日 下午4:50:30
 */
public class PrintMinNumber {
	public String PrintMinNumber(int[] numbers) {

		if (numbers == null || numbers.length == 0) {

			return "";
		}

		int len = numbers.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1; j++) {
				long num1 = Long.parseLong(numbers[j] + "" + numbers[j + 1]);
				long num2 = Long.parseLong(numbers[j + 1] + "" + numbers[j]);
				if (num1 > num2) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}

		StringBuilder sbd = new StringBuilder();

		for (int i = 0; i < len; i++) {
			sbd.append(numbers[i]);
		}
		return sbd.toString();
	}

	public static void main(String[] args) {
		System.out.println(new PrintMinNumber().PrintMinNumber(new int[] { 3, 5, 1, 4, 2 }));
	}
}
