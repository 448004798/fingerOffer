package com.ttan.stack;

import java.util.ArrayList;
import java.util.Stack;

import com.ttan.linkedList.ListNode;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月25日 下午5:20:59
 */
public class MaxInWindows {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (num.length < size || size <= 0) {
			return result;
		}
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < num.length && i + size < num.length + 1; i++) {
			int index = i;
			while (stack.size() < size && index < num.length) {
				stack.push(num[index++]);
			}
			if (stack.size() == size) {
				int max = stack.pop();
				while (!stack.isEmpty()) {
					int temp = stack.pop();
					max = max > temp ? max : temp;
				}
				result.add(max);
			}
		}
		return result;
	}
}
