package com.ttan.tree;

import java.util.ArrayList;

/**
 * @Description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * @author ttan
 * @time 2019年12月27日 上午11:15:30
 */
public class FindPath {
	private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

		if (root == null) {
			return result;
		}
		list.add(root.val);
		target -= root.val;

		if (target == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<Integer>(list));
		}

		// 因为在每一次的递归中，我们使用的是相同的result引用，所以其实左右子树递归得到的结果我们不需要关心，
		FindPath(root.left, target);
		FindPath(root.right, target);
		// 清除当前元素
        list.remove(list.size()-1);

		return result;
	}

}
