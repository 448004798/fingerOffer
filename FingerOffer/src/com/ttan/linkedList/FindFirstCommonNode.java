package com.ttan.linkedList;

/**
 * @Description: 两个链表的第一个公共结点
 * @author ttan
 * @time 2019年7月5日 下午3:36:46
 */
public class FindFirstCommonNode {

	/*输入两个链表，找出它们的第一个公共结点。*/

	/**
	 * 1->2->3->4
	 * 
	 * 3->4
	 */

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

		ListNode p1 = pHead1;
		ListNode p2 = pHead2;

		while (p1 != p2) {
			System.out.println("p1:" + p1 + " p2:" + p2);
			p1 = p1 == null ? pHead2 : p1.next;
			p2 = p2 == null ? pHead1 : p2.next;
		}

		return p1;
	}

	public static void main(String[] args) {

		ListNode pHead1 = new ListNode(1);
		ListNode pHead1next1 = new ListNode(2);
		ListNode pHead1next2 = new ListNode(3);
		ListNode pHead1next3 = new ListNode(4);

		pHead1.next = pHead1next1;
		pHead1next1.next = pHead1next2;
		pHead1next2.next = pHead1next3;

		System.out.println(new FindFirstCommonNode().FindFirstCommonNode(pHead1, pHead1next2));
	}
}
