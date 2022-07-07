package cn.wukai.algorithm.arrays;

/**
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 * using the following four rules (taken from the above Wikipedia article):
 * 1.任何相邻活细胞少于两个的活细胞都会死亡，由人口不足引起的。
 * 2.任何有两个或三个活邻居的活细胞都会延续到下一代。
 * 3.任何有三个以上活邻居的活细胞都会死亡，人口过多造成死亡
 * 4.任何只有三个活邻居的死细胞都会变成活细胞，就像通过繁殖一样。
 * 
 * request:编写一个函数来计算给定当前状态的电路板的下一个状态（在一次更新后）要求在o(1)空间复杂度下解题
 * @author wukai
 *
 */

public class GameofLife {

	/**
	 *1.如果不要求o(1)空间复杂度直接开一个新的二维数组记录就好
	 *2.对于要求o(1)空间复杂度
	 *状态0：死细胞转为死细胞
	 *状态1：活细胞转为活细胞
	 *状态2：活细胞转为死细胞
	 *状态3：死细胞转为活细胞
	 *得到这样一个矩阵后，最后将所有状态对2取模，状态0和2变成死细胞，1和3变成活细胞，就是所求的下一轮局面了。
	 * @param matrix
	 */
	public static void solution(int[][] matrix) {
		
		if(null == matrix || matrix[0].length == 0) {
			return;
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = helper(matrix,i,j);
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] %= 2;
			}
		}
		
	}

	private static int helper(int[][] matrix, int i, int j) {
		// TODO Auto-generated method stub
		int liveNum = 0;
		for (int m = -1; m <= 1; m++) {
			for (int n = -1; n <= 1; n++) {
				if(m == 0 && n == 0) {
					continue;
				}
				if(i + m >= 0 && i + m < matrix.length && j + n >= 0 && j + n < matrix[0].length 
						&& (matrix[i + m][j + n] == 1 || matrix[i][j] == 2)) {
					liveNum++;
				}
			}
		}
		//0:死-死 1:活-活 2:活-死3:死-活
		//int result = 0;
		if(liveNum > 3) {
			//变死
			if(matrix[i][j] == 1) {
				return 2;
			}else {
				return 0;
			}
		}else if(liveNum == 3) {
			//变活
			if(matrix[i][j] == 1) {
				return 1;
			}else {
				return 3;
			}
		}else if(liveNum == 2) {
			//活-活 死-死
			if(matrix[i][j] == 1) {
				return 1;
			}else {
				return 0;
			}
		}else if(liveNum < 2) {
			//变死
			if(matrix[i][j] == 1) {
				return 2;
			}else {
				return 0;
			}
		}
		return -1;
	}
	
}
