package com.ttan.binaryTree;

import java.util.Stack;

/**
 * @Description: 
 * @author ttan
 * @time 2019��12��16�� ����10:34:38
 */
public class TreeNodeFrontOption {

	// ǰ��������ݹ�ʵ�֣�
	public static void frontShow(TreeNode node) {
		System.out.print(node.val + " ");
		if (node.left != null) {
			frontShow(node.left);
		}
		if (node.right != null) {
			frontShow(node.right);
		}
	}

	// ǰ��������ǵݹ�ʵ�֣�
	public static void frontShow2(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (node != null || !stack.empty()) {
			if (node != null) {
				System.out.print(node.val + " ");
				stack.push(node);
				node = node.left;
			} else {
				TreeNode temp = stack.pop();
				node = temp.right;
			}
		}
	}

	// ǰ�����
	public static TreeNode frontSearch(TreeNode node, String key) {
		TreeNode result = null;
		if (node.val.equals(key)) {
			return node;
		}
		if (node.left != null) {
			result = frontSearch(node.left, key);
		}
		if (result != null) {
			return result;
		}
		if (node.right != null) {
			result = frontSearch(node.right, key);
		}
		return result;
	}

	public static void main(String[] args) {
		//frontShow(TreeNode.buildRoot());// A B D G H E C K F I J
		//System.out.println();
		//frontShow2(TreeNode.buildRoot());// A B D G H E C K F I J
		
		System.out.println(frontSearch(TreeNode.buildRoot(), "F"));
		System.out.println(frontSearch(TreeNode.buildRoot(), "Z"));

	}
}
