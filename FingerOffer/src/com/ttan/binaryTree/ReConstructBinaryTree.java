package com.ttan.binaryTree;

import java.util.Arrays;

/**
 * @Description: 
 * @author ttan
 * @time 2020��1��9�� ����5:25:35
 */
public class ReConstructBinaryTree {

	public static void main(String[] args) {
		System.out.println(new ReConstructBinaryTree().reConstructBinaryTree(new int[] { 1, 2, 4, 7, 3, 5, 6, 8 },
				new int[] { 4, 7, 2, 1, 5, 3, 8, 6 }));
	}

	// ����ǰ�����е�һ�����ȷ�������
	// ���ݸ���������������е�λ�÷ָ����������������
	// �����������������ֱ�ݹ�ʹ��ͬ���ķ��������ֽ�
	
	// �� ǰ������{1,2,4,7,3,5,6,8} = pre ,��������{4,7,2,1,5,3,8,6} = in
	// ���ݵ�ǰǰ�����еĵ�һ�����ȷ������㣬Ϊ 1
	// �ҵ� 1 ��������������е�λ�ã�Ϊ in[3]
	// �и������������� in[3] ǰ���Ϊ�������� in[3] �����Ϊ������
	// ���и���������ǰ������Ϊ��{2,4,7}���и�����������������Ϊ��{4,7,2}���и���������ǰ������Ϊ��{3,5,6,8}���и�����������������Ϊ��{5,3,8,6}
	// �������ֱ�ʹ��ͬ���ķ����ֽ�
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		// ǰ������ĵ�һ��Ԫ��Ϊ ���ڵ�
		TreeNode root = new TreeNode(pre[0]);
		int rootIndex = 0;
		for (int i = 0; i < in.length; i++) {
			// �ҵ� ���ڵ㣬�ɽ�������������Ϊ ������ �� ������ 
			if (in[i] == root.val) {
				rootIndex = i;
				break;
			}
		}
		//ע�� copyOfRange ����������ҿ�
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
