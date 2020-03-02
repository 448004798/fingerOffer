package com.ttan.tree;

/**
 * @Description: 
 * @author ttan
 * @time 2019年12月26日 下午5:12:01
 */
public class TreeNode {
	int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
}
