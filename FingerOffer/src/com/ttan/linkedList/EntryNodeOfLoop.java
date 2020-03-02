package com.ttan.linkedList;

/**
 * @Description: 
 * @author ttan
 * @time 2019��12��25�� ����11:17:54
 */
public class EntryNodeOfLoop {
	// ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
	public ListNode entryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return null;
		}
		// 1.���ÿ���ָ�룬����ָ��������������л���
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
		// 2.����ָ��ֱ������ͷ�����������������ÿ����һ�������һ�������뻷��ڡ�
		// �裺����ͷ������ڳ���Ϊ--a;����ڵ������㳤��Ϊ--b;�����㵽����ڳ���Ϊ--c
		// ��ָ��·��=a+(b+c)k+b ��k>=1  ����b+cΪ���ĳ��ȣ�kΪ�ƻ���Ȧ����k>=1,������һȦ��������0Ȧ����Ȼ����ָ���ߵ�һ������ì�ܣ�
		// ��ָ��·��=a+b
		// ��ָ���ߵ�·������ָ������������ԣ���a+b��*2=a+(b+c)k+b
		// ����ɵã�a=(k-1)(b+c)+c
		// ��������ͷ������ڵľ���=�����㵽����ڵľ���+��k-1��Ȧ�����ȡ�����k>=1,����k-1>=0Ȧ����������ָ��ֱ������ͷ����������������һ�������ڻ���ڡ�
		low = pHead;
		while (low != fast) {
			fast = fast.next;
			low = low.next;
		}
		return low;
	}
}
