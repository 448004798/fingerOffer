package com.ttan.stack;

import java.util.Stack;

/**
 * @Description:ջ��ѹ�롢��������
 * @author ttan
 * @time 2019��6��25�� ����9:49:31
 */
public class IsPopOrder {

	/*
	 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ���������1,2,3,4,
	 * 5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺
	 * ���������еĳ�������ȵģ�
	 */

	public boolean IsPopOrder(int[] pushA, int[] popA) {

		if (pushA.length == 0 || popA.length == 0) {
			return false;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int pushIndex = 0;
		int popIndex = 0;

		for (; pushIndex < pushA.length; pushIndex++) {
			stack.push(pushA[pushIndex]);

			while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {

				stack.pop();
				popIndex++;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		int[] pushA = { 1, 2, 3, 4, 5 };
		int[] popA = { 4, 5, 3, 2, 1 };
		System.out.println(new IsPopOrder().IsPopOrder(pushA, popA));
	}
}
