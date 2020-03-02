package com.ttan.linkedList;

/**
 * @Description: ��ת����
 * @author ttan
 * @time 2019��6��21�� ����3:57:56
 */
public class ReverseList {

	/* ����һ��������ת��������������ı�ͷ�� */

	public ListNode ReverseList(ListNode head) {

		if (head == null) {

			return null;
		}

		ListNode pre = null;
		ListNode next = null;

		while (head != null) {

			next = head.next;
			head.next = pre;

			pre = head;
			head = next;
		}

		return pre;

	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ListNode reverseList = new ReverseList().ReverseList(ln1);
		System.out.println(reverseList);
	}
}
