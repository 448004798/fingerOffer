package com.ttan.stack;

import java.util.Stack;

/**
 * @Description: ������ջʵ�ֶ���
 * @author ttan
 * @time 2019��6��15�� ����4:22:42
 */
public class TwoStackSimulationQueue {

	/*
	 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
	 */
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {

		stack1.push(node);
	}

	public int pop() {

		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.isEmpty() ? -1 : stack2.pop();
	}

	public static void main(String[] args) {
		TwoStackSimulationQueue queue = new TwoStackSimulationQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		queue.push(3);
		queue.push(4);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
}
