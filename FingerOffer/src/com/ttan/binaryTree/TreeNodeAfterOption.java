package com.ttan.binaryTree;

import java.util.Stack;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月17日 上午11:31:13
 */
public class TreeNodeAfterOption {

	// 后序遍历（递归实现）
	public static void afterShow(TreeNode node) {
		if (node.left != null) {
			afterShow(node.left);
		}
		if (node.right != null) {
			afterShow(node.right);
		}
		System.out.print(node.val + " ");
	}

	// 后序遍历（非递归实现）
	public static void afterShow2(TreeNode node) {
		TreeNode cur, pre = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while (!stack.empty()) {
			cur = stack.peek();
			if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
				System.out.print(cur.val + " ");
				stack.pop();
				pre = cur;
			} else {
				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
			}
		}
	}

	// 后序查找
	public static TreeNode afterSearch(TreeNode node, String key) {
		TreeNode result = null;
		if (node.left != null) {
			result = afterSearch(node.left, key);
		}
		if (result != null) {
			return result;
		}
		if (node.right != null) {
			result = afterSearch(node.right, key);
		}
		if (result != null) {
			return result;
		}
		if (node.val.equals(key)) {
			return node;
		}
		return result;
	}

	public static void main(String[] args) {
		// afterShow(TreeNode.buildRoot());// G H D E B K J I F C A
		// System.out.println();
		// afterShow2(TreeNode.buildRoot());// G H D E B K J I F C A
		System.out.println(afterSearch(TreeNode.buildRoot(), "A"));
		// TreeNode [val=A, left=TreeNode [val=B, left=TreeNode [val=D,
		// left=TreeNode [val=G, left=null, right=null], right=TreeNode [val=H,
		// left=null, right=null]], right=TreeNode [val=E, left=null,
		// right=null]], right=TreeNode [val=C, left=TreeNode [val=K, left=null,
		// right=null], right=TreeNode [val=F, left=TreeNode [val=I, left=null,
		// right=TreeNode [val=J, left=null, right=null]], right=null]]]
		System.out.println(afterSearch(TreeNode.buildRoot(), "C"));
		// TreeNode [val=C, left=TreeNode [val=K, left=null, right=null],
		// right=TreeNode [val=F, left=TreeNode [val=I, left=null,
		// right=TreeNode [val=J, left=null, right=null]], right=null]]

	}
}
