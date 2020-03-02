package com.ttan.tree;

/**
 * @Description: �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * @author ttan
 * @time 2019��12��26�� ����5:11:35
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
		// �ݹ���ڵ㡢�ҽڵ㣬��һ�����root2ֵ��ȣ���ݹ��ж����ǵ������ӽڵ��Ƿ����
		if (root1.val != root2.val) {
			return judgeSubtree(root1.left, root2) || judgeSubtree(root1.right, root2);
		}
		return judgeSubtree(root1.left, root2.left) && judgeSubtree(root1.right, root2.right);
	}
}
