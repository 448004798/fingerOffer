package com.ttan.binaryTree;

import java.util.Stack;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月17日 上午10:34:20
 */
public class TreeNodeMidOption {

	// 中序遍历（递归实现）
	public static void midShow(TreeNode node) {
		if (node.left != null) {
			midShow(node.left);
		}
		System.out.print(node.val + " ");
		if (node.right != null) {
			midShow(node.right);
		}
	}

	// 中序遍历（非递归实现）
	public static void midShow2(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null || !stack.empty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				TreeNode temp = stack.pop();
				System.out.print(temp.val + " ");
				node = temp.right;
			}
		}
	}

	// 中序查找
	public static TreeNode midSearch(TreeNode node, String key) {
		TreeNode result = null;
		if (node.left != null) {
			result = midSearch(node.left, key);
		}
		if (result != null) {
			return result;
		}
		if (node.val.equals(key)) {
			return node;
		}
		if (node.right != null) {
			result = midSearch(node.right, key);
		}
		return result;
	}

	public static void main(String[] args) {
		//midShow(TreeNode.buildRoot());// G D H B E A K C I J F
		//System.out.println();
		//midShow2(TreeNode.buildRoot());// G D H B E A K C I J F
		System.out.println(midSearch(TreeNode.buildRoot(), "D"));
		// TreeNode [val=D, left=TreeNode [val=G, left=null, right=null], right=TreeNode [val=H, left=null, right=null]]
		System.out.println(midSearch(TreeNode.buildRoot(), "I"));
		// TreeNode [val=I, left=null, right=TreeNode [val=J, left=null, right=null]]

	}
}
