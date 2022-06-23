package cn.wukai.algorithm.arrays;

/**
 * Given a m × n matrix, if an element is 0, set its entire row and column to 0. 
 * Do it in place.
Follow up: Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * @author wukai
 *
 */

public class SetMatrixZeroes {

	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,0},{1,1,1,1}};
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		
		solution2(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * 1.使用两个boolean数组 记录是否需要置0 
	 * 2.这种方法需要o(m + n)的额外空间
	 * @param nums
	 */
	public static void solution(int[][] matrix) {
		if(null == matrix || matrix.length == 0) {
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[] row = new boolean[m];
		boolean[] low = new boolean[n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					low[j] = true;
				}
			}
		}
		for (int i = 0; i < low.length; i++) {
			System.out.print(low[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < row.length; i++) {
			System.out.print(row[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("row["+i+"] = " + row[i] + " low[" + j+"]" + low[j]);
				if(row[i] || low[j]) {
					matrix[i][j] = 0;
				}
				System.out.println(matrix[i][j]);
			}
		}
	}
	
	/**
	 * 1.使用o(1)额外空间
	 * @param matrix
	 */
	public static void solution2(int[][] matrix) {
		
		if(null == matrix || matrix.length == 0){
			return;
		}
		boolean row_has_zero = false; //记录第一行是否有0
		boolean col_has_zero = false; //记录第一列是否有0
		
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				col_has_zero = true;
				break;
			}
		}
		
		for (int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				row_has_zero = true;
				break;
			}
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(row_has_zero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		
		if(col_has_zero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
}
