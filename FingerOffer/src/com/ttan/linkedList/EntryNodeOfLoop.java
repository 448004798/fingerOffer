package com.ttan.linkedList;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月25日 上午11:17:54
 */
public class EntryNodeOfLoop {
	// 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
	public ListNode entryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		// 1.设置快慢指针，快慢指针相遇，则代表有环。
		ListNode fast = pHead;
		ListNode low = pHead;
		while (fast != null && fast.next != null) {
			low = low.next;
			fast = fast.next.next;
			if (low == fast) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		// 2.两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
		// 设：链表头到环入口长度为--a;环入口到相遇点长度为--b;相遇点到环入口长度为--c
		// 快指针路程=a+(b+c)k+b ，k>=1  其中b+c为环的长度，k为绕环的圈数（k>=1,即最少一圈，不能是0圈，不然和慢指针走的一样长，矛盾）
		// 慢指针路程=a+b
		// 快指针走的路程是慢指针的两倍，所以：（a+b）*2=a+(b+c)k+b
		// 化简可得：a=(k-1)(b+c)+c
		// 即：链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。其中k>=1,所以k-1>=0圈。所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
		low = pHead;
		while (low != fast) {
			fast = fast.next;
			low = low.next;
		}
		return low;
	}
}
