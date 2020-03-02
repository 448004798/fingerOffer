package com.ttan.array;

import java.util.ArrayList;

/**
 * @Description: 顺时针打印矩阵
 * @author ttan
 * @time 2019年6月24日 下午12:03:37
 */
public class PrintMatrix {

	/*
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11
	 * 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 */

	// 1 2 3 4
	// 5 6 7 8
	// 9 10 11 12
	// 13 14 15 16

	// 1 2 3
	// 4 5 6
	// 7 8 9
	// 10 11 12

	// 1 2 3 4

	// 1
	// 2
	// 3
	// 4
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		ArrayList<Integer> resultList = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return resultList;
		}

		int colIndex = 0;
		int rowIndex = 0;

		int colMaxIndex = matrix[0].length - 1;
		int rowMaxIndex = matrix.length - 1;

		while (colIndex <= colMaxIndex && rowIndex <= rowMaxIndex) {

			for (int i = colIndex; i <= colMaxIndex; i++) {
				resultList.add(matrix[rowIndex][i]);
			}
			for (int j = rowIndex + 1; j <= rowMaxIndex; j++) {
				resultList.add(matrix[j][colMaxIndex]);
			}
			if (rowIndex != rowMaxIndex) {
				for (int k = colMaxIndex - 1; k >= colIndex; k--) {
					resultList.add(matrix[rowMaxIndex][k]);
				}
			}
			if (colIndex != colMaxIndex) {
				for (int l = rowMaxIndex - 1; l >= rowIndex + 1; l--) {
					resultList.add(matrix[l][rowIndex]);
				}
			}
			colMaxIndex--;
			rowMaxIndex--;
			colIndex++;
			rowIndex++;
		}
		return resultList;
	}

	public static void main(String[] args) {
		// int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9,
		// 10, 11, 12 }, { 13, 14, 15, 16 } };
		//int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 }, { 13, 14, 15 } };
		// int[][] matrix = new int[][] { { 1, 2, 3, 4 }};
		 int[][] matrix = new int[][] { { 1 }, { 2 }, { 3 }, { 4 } };
		// int[][] matrix = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }
		// };
		// int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
		// { 11, 12, 13, 14, 15 } };
		System.out.println(new PrintMatrix().printMatrix(matrix));
	}
}
