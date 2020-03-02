package com.ttan.linkedList;

import java.util.ArrayList;

/**
 * @Description: ��β��ͷ��ӡ����
 * @author ttan
 * @time 2019��6��15�� ����4:04:37
 */
public class PrintListFromTailToHead {

	/* ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList�� */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		return printList(listNode, list);
	}

	private ArrayList<Integer> printList(ListNode listNode, ArrayList<Integer> list) {

		if (listNode != null) {
			printList(listNode.next, list);
			list.add(listNode.val);
		}
		return list;
	}

	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;

		System.out.println(new PrintListFromTailToHead().printListFromTailToHead(listNode1));
	}
}
