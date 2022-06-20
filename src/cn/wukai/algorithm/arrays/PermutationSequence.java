package cn.wukai.algorithm.arrays;

import java.util.Arrays;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3 ):
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k , return the kth permutation sequence.
Note: Given n will be between 1 and 9 inclusive.
 * @author wukai
 *
 */

public class PermutationSequence {

	public static void main(String[] args) {
		System.out.println(solution(3, 1));
	}
	
	public static String solution(int n, int k) {
		if(calResult(n) < k || k < 1) {
			return null;
		}
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		
		NextPermutation nextPermutation = new NextPermutation();
		for (int i = 0; i < k - 1; i++) {
			nextPermutation.solution(nums);
		}
		return Arrays.toString(nums);
	}
	
	private static int calResult(int n) {
		if(n == 1) {
			return 1;
		}else {
			return n * calResult(n - 1);
		}
	}
	
}
