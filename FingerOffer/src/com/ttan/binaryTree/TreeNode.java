package com.ttan.binaryTree;

/**
 * @Description:
 * @author ttan
 * @time 2019年6月15日 下午4:18:34
 */
public class TreeNode {
	// 节点的权
	String val;
	// 左节点
	TreeNode left;
	// 右节点
	TreeNode right;

	TreeNode(String val) {
		this.val = val;
	}

	public static TreeNode buildRoot() {
		TreeNode a = new TreeNode("A");
		TreeNode b = new TreeNode("B");
		TreeNode c = new TreeNode("C");
		TreeNode d = new TreeNode("D");
		TreeNode e = new TreeNode("E");
		TreeNode f = new TreeNode("F");
		TreeNode g = new TreeNode("G");
		TreeNode h = new TreeNode("H");
		TreeNode i = new TreeNode("I");
		TreeNode j = new TreeNode("J");
		TreeNode k = new TreeNode("K");

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = k;
		c.right = f;
		d.left = g;
		d.right = h;
		f.left = i;
		i.right = j;
		return a;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	// 删除子树
	public static TreeNode deleteNode(TreeNode node, String key) {
		TreeNode result = null;
		if (node.left != null && node.left.val.equals(key)) {
			result = node.left;
			node.left = null;
			return result;
		}
		if (node.right != null && node.right.val.equals(key)) {
			result = node.right;
			node.right = null;
			return result;
		}
		if (node.left != null) {
			result = deleteNode(node.left, key);
		}
		if (result != null) {
			return result;
		}
		if (node.right != null) {
			result = deleteNode(node.right, key);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	public static void main(String[] args) {
		TreeNode root = TreeNode.buildRoot();
		System.out.println(TreeNodeFrontOption.frontSearch(root, "E"));//TreeNode [val=E, left=null, right=null]
		System.out.println(deleteNode(root, "E"));//TreeNode [val=E, left=null, right=null]
		System.out.println(TreeNodeFrontOption.frontSearch(root, "E"));//null
	}
}
