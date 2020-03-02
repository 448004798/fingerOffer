package com.ttan.linkedList.randomListNode;

/**
 * @Description: 复杂链表的复制
 * @author ttan
 * @time 2019年6月25日 上午10:28:56
 */
public class CloneRandomListNode {

	public RandomListNode Clone(RandomListNode pHead) {

		/*
		 * 1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
		 * 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
		 * 3、拆分链表，将链表拆分为原链表和复制后的链表
		 */
		if (pHead == null) {
			return null;
		}

		RandomListNode currentNode = pHead;
		// 1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
		// A - A` - B - B` - C - C` - D - D`
		while (currentNode != null) {
			RandomListNode cloneNode = new RandomListNode(currentNode.label);
			RandomListNode nextNode = currentNode.next;
			currentNode.next = cloneNode;
			cloneNode.next = nextNode;
			currentNode = nextNode;
		}

		currentNode = pHead;
		// 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
		while (currentNode != null) {
			currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
			currentNode = currentNode.next.next;
		}
		// 3、拆分链表，将链表拆分为原链表和复制后的链表
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
