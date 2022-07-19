package cn.wukai.algorithm.arrays;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 
 * exists or not in the array.
 * More specifically, if there exists i , j , k such that arr[i] < arr[j] < arr[k] 
 * given 0 ≤ i < j< k ≤ n-1 return true else return false .
 * Your function should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5] , return true .
 * Given [5, 4, 3, 2, 1] , return false .
 * @author wukai
 *
 */

public class IncreasingTripletSubsequence {

	public static void main(String[] args) {
		int[] nums = {5, 2, 3, 1, 3};
		System.out.println(solution(nums));
	}
	
	public static boolean solution(int[] nums) {
		int x1 = Integer.MAX_VALUE;
		int x2 = Integer.MAX_VALUE;
		
		for (int i : nums) {
			if(i <= x1) {
				x1 = i;
			}else if(i <= x2) {
				x2 = i;
			}else {
				return true;
			}
		}
		
		return false;
	}
	
}
