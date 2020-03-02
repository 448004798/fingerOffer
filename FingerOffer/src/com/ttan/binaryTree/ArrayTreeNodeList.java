package com.ttan.binaryTree;

/**
 * @Description: 
 * @author ttan
 * @time 2019��12��18�� ����2:22:14
 */
public class ArrayTreeNodeList {

	// ǰ�����
	public static void frontShow(int[] data, int index) {
		if (index > data.length - 1) {
			return;
		}
		System.out.print(data[index] + " ");
		// �������� 2*n+1
		if (2 * index + 1 <= data.length - 1) {
			frontShow(data, 2 * index + 1);
		}
		// �������� 2*n+2
		if (2 * index + 2 <= data.length - 1) {
			frontShow(data, 2 * index + 2);
		}
	}
	public static void main(String[] args) {
		int[] data = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		frontShow(data, 0);//1 2 4 5 3 6 7
	}
}
