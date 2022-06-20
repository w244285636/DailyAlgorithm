package cn.wukai.algorithm.arrays;

import java.util.Arrays;

/**
 * There are just 3 rules to Sudoku
 * 1.Each row must have the numbers 1-9 occuring just once.
 * 2.Each column must have the numbers 1-9 occuring just once.
 * 3.And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
 * 
 * The Sudoku board could be partially filled, 
 * where empty cells are filled with the character '.'
 * @author wukai
 *
 */

public class ValidSudoku {

	public static boolean solution(char[][] board) {
		boolean[] used = new boolean[9];
		
		//检查行和列是否满足要求
		for (int i = 0; i < 9; i++) {
			Arrays.fill(used, false);
			
			for (int j = 0; j < 9; j++) {
				//判断行是否满足条件
				if(!check(board[i][j], used))
					return false;
			}
			
			Arrays.fill(used, false);
			for (int j = 0; j < 9; j++) {
				//判断列是否满足要求
				if(!check(board[j][i], used))
					return false;
			}
			
		}
		
		//检查9宫格是否满足要求
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Arrays.fill(used, false);
				for (int c = i * 3; c < i*3 + 3; c++) {
					for (int l = j * 3; l < j * 3 + 3; l++) {
						if(!check(board[i][j], used)) {
							return false;
						}
					}
				}
				
			}
		}
		
		return true;
				
	}
	
	private static boolean check(char ch, boolean[] used) {
		if(ch == '.') return true;
		if(used[ch - '1']) return false;
		
		return used[ch - '1'] = true;
	}
	
}
