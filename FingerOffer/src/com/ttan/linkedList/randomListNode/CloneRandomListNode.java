package com.ttan.linkedList.randomListNode;

/**
 * @Description: ��������ĸ���
 * @author ttan
 * @time 2019��6��25�� ����10:28:56
 */
public class CloneRandomListNode {

	public RandomListNode Clone(RandomListNode pHead) {

		/*
		 * 1��������������ÿ����㣬�縴�ƽ��A�õ�A1�������A1�嵽���A���棻
		 * 2�����±������������Ͻ������ָ����½�㣬��A1.random = A.random.next;
		 * 3�����������������Ϊԭ����͸��ƺ������
		 */
		if (pHead == null) {
			return null;
		}

		RandomListNode currentNode = pHead;
		// 1������ÿ����㣬�縴�ƽ��A�õ�A1�������A1�嵽���A���棻
		// A - A` - B - B` - C - C` - D - D`
		while (currentNode != null) {
			RandomListNode cloneNode = new RandomListNode(currentNode.label);
			RandomListNode nextNode = currentNode.next;
			currentNode.next = cloneNode;
			cloneNode.next = nextNode;
			currentNode = nextNode;
		}

		currentNode = pHead;
		// 2�����±������������Ͻ������ָ����½�㣬��A1.random = A.random.next;
		while (currentNode != null) {
			currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
			currentNode = currentNode.next.next;
		}
		// 3�����������������Ϊԭ����͸��ƺ������
		currentNode = pHead;
		RandomListNode clonePHead = pHead.next;
		while (currentNode != null) {
			RandomListNode cloneNode = currentNode.next;
			currentNode.next = cloneNode.next;
			cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
			currentNode = currentNode.next;
		}
		return clonePHead;
	}

}
