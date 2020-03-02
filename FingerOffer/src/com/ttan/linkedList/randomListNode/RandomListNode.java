package com.ttan.linkedList.randomListNode;

/**
 * @Description:
 * @author ttan
 * @time 2019年6月25日 上午10:28:26
 */
public class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "RandomListNode [label=" + label + ", next=" + next + ", random=" + random + "]";
	}
}
