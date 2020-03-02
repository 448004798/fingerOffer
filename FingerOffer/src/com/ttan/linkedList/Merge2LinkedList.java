package com.ttan.linkedList;

/**
 * @Description: �ϲ��������������
 * @author ttan
 * @time 2019��6��24�� ����10:44:01
 */
public class Merge2LinkedList {

	/*
	 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
	 * 
	 * 1->3->5->7;2->4->6->8
	 */

	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		ListNode mergeHead = null;
		ListNode current = null;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				if (mergeHead == null) {
					mergeHead = current = list1;
				} else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			} else {
				if (mergeHead == null) {
					mergeHead = current = list2;
				} else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			current.next = list2;
		} else {
			current.next = list1;
		}
		return mergeHead;
		
		/* //�ݹ�����
	       if(list1 == null){
	           return list2;
	       }
	       if(list2 == null){
	           return list1;
	       }
	       if(list1.val <= list2.val){
	           list1.next = Merge(list1.next, list2);
	           return list1;
	       }else{
	           list2.next = Merge(list1, list2.next);
	           return list2;
	       }  */
	}

	public static void main(String[] args) {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(3);
		ListNode ln3 = new ListNode(5);
		ln1.next = ln2;
		ln2.next = ln3;

		ListNode ln11 = new ListNode(3);
		ListNode ln22 = new ListNode(4);
		ListNode ln33 = new ListNode(7);
		ln11.next = ln22;
		ln22.next = ln33;

		ListNode MergeList = new Merge2LinkedList().Merge(ln1, ln11);
		System.out.println(MergeList);
	}
}
