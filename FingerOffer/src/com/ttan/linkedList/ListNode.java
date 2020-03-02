package com.ttan.linkedList;

/**
 * @Description: ����
 * @author ttan
 * @time 2019��6��15�� ����4:05:21
 */
public class ListNode {
	public int val;
	public ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
}
