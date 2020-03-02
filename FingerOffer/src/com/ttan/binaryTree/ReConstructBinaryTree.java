package com.ttan.binaryTree;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2020年1月9日 下午5:25:35
 */
public class ReConstructBinaryTree {

	public static void main(String[] args) {
		System.out.println(new ReConstructBinaryTree().reConstructBinaryTree(new int[] { 1, 2, 4, 7, 3, 5, 6, 8 },
				new int[] { 4, 7, 2, 1, 5, 3, 8, 6 }));
	}

	// 根据前序序列第一个结点确定根结点
	// 根据根结点在中序序列中的位置分割出左右两个子序列
	// 对左子树和右子树分别递归使用同样的方法继续分解
	
	// 如 前序序列{1,2,4,7,3,5,6,8} = pre ,中序序列{4,7,2,1,5,3,8,6} = in
	// 根据当前前序序列的第一个结点确定根结点，为 1
	// 找到 1 在中序遍历序列中的位置，为 in[3]
	// 切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树
	// 则切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}；切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6}
	// 对子树分别使用同样的方法分解
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		// 前序遍历的第一个元素为 根节点
		TreeNode root = new TreeNode(pre[0]);
		int rootIndex = 0;
		for (int i = 0; i < in.length; i++) {
			// 找到 根节点，可将中序遍历数组分为 左子树 和 右子树 
			if (in[i] == root.val) {
				rootIndex = i;
				break;
			}
		}
		//注意 copyOfRange 函数，左闭右开
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1),
				Arrays.copyOfRange(in, 0, rootIndex));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
				Arrays.copyOfRange(in, rootIndex + 1, in.length));
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
}
