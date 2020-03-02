package com.ttan.array;

/**
 * @Description:二维数组中的查找
 * @author ttan
 * @time 2019年6月15日 下午3:43:03
 */
public class Find2DimensinalArray {
	/*
	 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
	 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
