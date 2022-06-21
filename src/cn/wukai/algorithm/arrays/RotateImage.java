package cn.wukai.algorithm.arrays;

/**
 * You are given an n × n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Follow up: Could you do this in-place?
 * @author wukai
 *
 */

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------");
		solution(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * 1.先副对角线翻转
	 * 2.再中线翻转
	 * @param matrix
	 */
	public static void solution(int[][] matrix) {
		if(null == matrix || matrix.length == 0) {
			return ;
		}
		int n = matrix.length;
		//1.副对角线翻转
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i + j == n - 1) {
					break;
				}
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][n - i - 1];
				matrix[n - j - 1][n - i - 1]  = tmp;
			}
		}
		
		//2中线翻转
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = tmp;
			}
		}
	}
	
}
