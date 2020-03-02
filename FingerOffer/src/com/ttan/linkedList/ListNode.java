package com.ttan.linkedList;

/**
 * @Description: 链表
 * @author ttan
 * @time 2019年6月15日 下午4:05:21
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
