package com.ttan.linkedList;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月24日 下午5:52:45
 */
public class DeleteDuplication {
	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		// 备用头节点，因为头节点可能删除
		ListNode firstNode = new ListNode(-1);

		firstNode.next = pHead;
		ListNode cur = pHead;
		// 前节点
		ListNode pre = firstNode;

		while (cur != null && cur.next != null) {
			// 两节点相等
			if (cur.val == cur.next.val) {
				// 记录val值，循环判断后面是否有相同值的节点
				int val = cur.val;
				// 循环跳过，删除
				while (cur != null && cur.val == val) {
					cur = cur.next;
				}
				// 删除操作，直接指向不同于val值的第一个节点
				pre.next = cur;
			}else{
				pre = cur;
				cur = cur.next;
			}
		}
		return firstNode.next;
	}

	public static void main(String[] args) {
		ListNode pHead = new ListNode(1);
		ListNode listNode = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(4);
		ListNode listNode6 = new ListNode(5);
		pHead.next = listNode;
		listNode.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		System.out.println(deleteDuplication(pHead));
	}
}
