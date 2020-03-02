package com.ttan.tree;

import java.util.ArrayList;

/**
 * @Description: ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 * @author ttan
 * @time 2019��12��27�� ����11:15:30
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

		// ��Ϊ��ÿһ�εĵݹ��У�����ʹ�õ�����ͬ��result���ã�������ʵ���������ݹ�õ��Ľ�����ǲ���Ҫ���ģ�
		FindPath(root.left, target);
		FindPath(root.right, target);
		// �����ǰԪ��
        list.remove(list.size()-1);

		return result;
	}

}
