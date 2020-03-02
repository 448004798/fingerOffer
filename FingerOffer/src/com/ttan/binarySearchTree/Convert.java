package com.ttan.binarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 
 * @author ttan
 * @time 2020��1��10�� ����10:03:01
 */
public class Convert {

	public TreeNode Convert(TreeNode pRootOfTree) {
		TreeNode result = null;
		TreeNode cur = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (pRootOfTree != null || !stack.isEmpty()) {
			if (pRootOfTree != null) {
				stack.push(pRootOfTree);
				pRootOfTree = pRootOfTree.left;
			} else {
				TreeNode node = stack.pop();
				if (result == null) {
					result = node;
					result.left = null;
					cur = result;
				} else {
					cur.right = node;
					node.left = cur;
					cur = cur.right;
				}
				node = node.right;
			}
		}
		cur.right = null;
		return result;
	}

	boolean isSymmetrical(TreeNode pRoot) {
		ArrayList<TreeNode> preList = new ArrayList<TreeNode>();
		// �������
		preOrder(pRoot, preList);
		// ��ȡ���ڵ�����
		int mid = preList.size() / 2;
		for (int leftIndex = 0, rightIndex = mid + 1; leftIndex < mid
				&& rightIndex < preList.size(); leftIndex++, rightIndex++) {
			if (preList.get(leftIndex).data != preList.get(rightIndex).data) {
				return false;
			}
		}
		return true;
	}

	// �������
	public void preOrder(TreeNode pRoot, ArrayList<TreeNode> preList) {
		if (pRoot == null) {
			return;
		}
		preOrder(pRoot.left, preList);
		preList.add(pRoot);
		preOrder(pRoot.right, preList);
	}

	public static void main(String[] args) {
		TreeNode pRoot = new TreeNode(1);
		TreeNode pRoot2 = new TreeNode(2);
		TreeNode pRoot3 = new TreeNode(3);
		TreeNode pRoot4 = new TreeNode(4);
		TreeNode pRoot5 = new TreeNode(2);
		TreeNode pRoot6 = new TreeNode(3);
		TreeNode pRoot7 = new TreeNode(4);

		pRoot.left = pRoot2;
		pRoot2.left = pRoot3;
		pRoot2.right = pRoot4;

		pRoot.right = pRoot5;
		pRoot5.left = pRoot6;
		pRoot5.right = pRoot7;

		System.out.println(new Convert().isSymmetrical(pRoot));
	}
}

class TreeNode {
	// �ڵ���
	int data; // ������
	TreeNode right; // ������
	TreeNode left; // ������

	public TreeNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}


}
