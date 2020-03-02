package com.ttan.stack;

import java.util.Stack;

/**
 * @Description: 包含min函数的栈
 * @author ttan
 * @time 2019年6月24日 下午4:29:33
 */
public class MinFuncStack {

	private Stack<Integer> stack = new Stack<Integer>();
	private Integer[] minArray = new Integer[9999];
	private int effectiveLength = 0;

	public void push(int node) {
		if (stack.isEmpty()) {
			minArray[0] = node;
		} else {
			if (node < minArray[0]) {
				for (int i = effectiveLength - 1; i > -1; i--) {
					minArray[i + 1] = minArray[i];
				}
				minArray[0] = node;
			} else {
				for (int i = 0, len = effectiveLength; i < len; i++) {
					Integer temp = minArray[i];
					if (node < temp) {
						for (int j = len - 1; j >= i; j--) {
							minArray[j + 1] = minArray[j];
						}
						minArray[i] = node;
						break;
					}
					if (i + 1 == len) {
						minArray[i + 1] = node;
					}
				}
			}
		}
		effectiveLength++;
		stack.push(node);
	}

	public void pop() {
		if (!stack.isEmpty()) {
			Integer popTemp = stack.pop();
			for (int i = 0, len = effectiveLength; i < len; i++) {
				Integer minTemp = minArray[i];
				if (popTemp.equals(minTemp)) {
					for (int j = i; j < effectiveLength; j++) {
						minArray[j] = minArray[j + 1];
					}
				}
			}
		}
		effectiveLength--;
	}

	public int top() {

		return stack.peek();
	}

	public int min() {

		return minArray[0];
	}
	
	
	public static void main(String[] args) {
		MinFuncStack mfs = new MinFuncStack();
		mfs.push(2);
		mfs.push(3);
		mfs.push(4);
		mfs.push(1);
		mfs.push(6);
		System.out.println(mfs.top());
		System.out.println(mfs.min());
		mfs.pop();
		mfs.pop();
		System.out.println(mfs.top());
		System.out.println(mfs.min());
	}

}
