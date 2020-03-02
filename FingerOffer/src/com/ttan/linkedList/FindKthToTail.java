package com.ttan.linkedList;

/**
 * @Description: �����е�����k�����
 * @author ttan
 * @time 2019��6��21�� ����3:26:12
 */
public class FindKthToTail {

	/* ����һ����������������е�����k����㡣 */

	public ListNode FindKthToTail(ListNode head, int k) {

		if (head == null || k <= 0) {
			return null;
		}
		ListNode pre = head;
		ListNode last = head;
		for (int i = 1; i < k; i++) {
			if (pre.next != null) {
				pre = pre.next;
			} else {
				return null;
			}
		}

		while (pre.next != null) {
			pre = pre.next;
			last = last.next;
		}
		return last;
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
		int k = 3;
		ListNode findKthToTail = new FindKthToTail().FindKthToTail(ln1, k);
		System.out.println(findKthToTail);
		System.out.println(findKthToTail.val);
	}
}
