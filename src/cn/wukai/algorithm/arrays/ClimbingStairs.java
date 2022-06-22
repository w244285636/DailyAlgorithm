package cn.wukai.algorithm.arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * 1.假设爬到n阶梯共有f(n)方法
 * 2.爬到n阶梯有两种方法 ：a在n-1阶梯爬上去， b在n-2阶梯爬上去
 * 3.故有 f(n) = f(n-1) + f(n-2)
 * @author wukai
 *
 */

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution2(n));
	}
	
	/**
	 * 斐波那契数列   递归
	 * @param n
	 * @return
	 */
	public static int solution1(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return solution1(n - 1) + solution1(n - 2);
		
	}
	
	/**
	 * 迭代方法
	 * @param n
	 * @return
	 */
	public static int solution2(int n) {
		int prev = 0;
		int cur = 1;
		for (int i = 1; i <= n; i++) {
			int tmp = cur;
			cur += prev;
			prev = tmp;
		}
		return cur;
	}
	
	
}
