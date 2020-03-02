package com.ttan.numMath;

/**
 * @Description: 
 * @author ttan
 * @time 2020年1月6日 下午5:35:45
 */
public class IsContinuous {
	public static boolean isContinuous(int[] numbers) {
		int min = -1, max = -1;
		int jokers = 0;
		for (int i = 0; i < numbers.length; i++) {
			int temp = numbers[i];
			if (temp == 0) {
				jokers++;
			} else {
				if (min == -1 && max == -1) {
					min = max = temp;
				} else {
					if (temp <= min) {
						min = temp;
					} else if (temp > max) {
						max = temp;
					}
				}
			}
		}
		if (jokers == 5) {
			return true;
		} else if (max - min > 4) {
			return false;
		}
		check: while (min <= max) {
			for (int i = 0; i < numbers.length; i++) {
				if (min == numbers[i]) {
					min++;
					continue check;
				}
			}
			if (jokers > 0) {
				jokers--;
				min++;
				continue;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isContinuous(new int[] { 1, 0, 6, 5, 4 }));
	}
}
