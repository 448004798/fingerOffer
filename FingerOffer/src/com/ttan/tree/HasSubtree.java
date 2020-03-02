package com.ttan.tree;

/**
 * @Description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author ttan
 * @time 2019年12月26日 下午5:11:35
 */
public class HasSubtree {

	public boolean hasSubtree(TreeNode root1, TreeNode root2) {

		if (root1 == null || root2 == null) {
			return false;
		}
		
		return judgeSubtree(root1, root2) || judgeSubtree(root1.left, root2) || judgeSubtree(root1.right, root2);
	}

	private boolean judgeSubtree(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		// 递归左节点、右节点，有一满足和root2值相等，则递归判断他们的左右子节点是否都相等
		if (root1.val != root2.val) {
			return judgeSubtree(root1.left, root2) || judgeSubtree(root1.right, root2);
		}
		return judgeSubtree(root1.left, root2.left) && judgeSubtree(root1.right, root2.right);
	}
}
