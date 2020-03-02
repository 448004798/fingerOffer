package com.ttan.array;

/**
 * @Description:��ά�����еĲ���
 * @author ttan
 * @time 2019��6��15�� ����3:43:03
 */
public class Find2DimensinalArray {
	/*
	 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
	 * ����������һ����ά�����һ���������ж��������Ƿ��и�������
	 */
	public boolean Find(int target, int[][] array) {

		int row = 0;
		int col = array[0].length - 1;
		int colTemp = col;
		while (row < array.length) {
			if (colTemp < 0) {
				row++;
				colTemp = col;
			} else {
				int temp = array[row][colTemp];
				if (target > temp) {
					row++;
					colTemp = col;
				} else if (target < temp) {
					colTemp--;
				} else {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int target = 5;
		System.out.println(new Find2DimensinalArray().Find(target, array));
	}
}
