package cn.wukai.algorithm.arrays;

/**
 * Given an array of n integers where n > 1 , nums , 
 * return an array output such that output[i] is equal to the product 
 * of all the elements of nums except nums[i] .
 * Solve it without division and in O(n) .
 * For example, given [1,2,3,4] , return [24,12,8,6] .
 * Follow up:
 * Could you solve it with constant space complexity? 
 * (Note: The output array does not count as extra space
 * for the purpose of space complexity analysis.)
 * @author wukai
 *
 */

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] result = solution2(nums);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * numsFirst = {1,a1,a1* a2, a1*a2*a3};
	 * numsSecond = {a2*a3*a4,a3*a4,a4,1};
	 * numsFirst*numsSecond 即为结果
	 * 时间复杂度o(n) 空间复杂度o(n)
	 * @param nums
	 * @return
	 */
	public static int[] solution1(int[] nums) {
		if(null == nums || nums.length == 0) {
			return null;
		}
		
		int[] numsFirst = new int[nums.length];
		int[] numsSecond = new int[nums.length];
		
		numsFirst[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			numsFirst[i] = nums[i - 1] * numsFirst[i - 1];
		}
		
		numsSecond[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			numsSecond[i] = nums[i + 1] * numsSecond[i + 1];
		}
		
		int[] result = new int[nums.length];
		for (int i = 0; i < numsSecond.length; i++) {
			result[i] = numsFirst[i] * numsSecond[i];
		}
		
		return result;
	}
	
	/**
	 * 时间复杂度o(n) 空间复杂度o(1)
	 * @param nums
	 * @return
	 */
	public static int[] solution2(int[] nums) {
		if(null == nums || nums.length == 0) {
			return null;
		}
		int[] result = new int[nums.length];
		
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = nums[i - 1] * result[i - 1];
		}
		
		int right = 1;
		for (int i = nums.length - 1; i >= 0 ; i--) {
			result[i] *= right;
			right *= nums[i];
		}
		
		return result;
	}
	
}
