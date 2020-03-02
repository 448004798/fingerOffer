package com.ttan.linkedList;

/**
 * @Description: 
 * @author ttan
 * @time 2019��12��24�� ����5:52:45
 */
public class DeleteDuplication {
	public static ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		// ����ͷ�ڵ㣬��Ϊͷ�ڵ����ɾ��
		ListNode firstNode = new ListNode(-1);

		firstNode.next = pHead;
		ListNode cur = pHead;
		// ǰ�ڵ�
		ListNode pre = firstNode;

		while (cur != null && cur.next != null) {
			// ���ڵ����
			if (cur.val == cur.next.val) {
				// ��¼valֵ��ѭ���жϺ����Ƿ�����ֵͬ�Ľڵ�
				int val = cur.val;
				// ѭ��������ɾ��
				while (cur != null && cur.val == val) {
					cur = cur.next;
				}
				// ɾ��������ֱ��ָ��ͬ��valֵ�ĵ�һ���ڵ�
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
