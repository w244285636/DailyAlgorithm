package cn.wukai.algorithm.arrays;

/**
 * Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3 , the array [1,2,3,4,5,6,7] 
is rotated to [5,6,7,1,2,3,4] .
Note: Try to come up as many solutions as you can, 
there are at least 3 different ways to solve this problem.
 * @author wukai
 *
 */

public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		solution3(nums, 3);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * 方法一：开一个k数组 将右边k元素放进去，然后将n-k右移k位，将k数组填充头部k位置
	 * 时间复杂度 o(n) 空间复杂度 o(k)
	 * @param nums
	 * @param k
	 */
	public static void solution1(int[] nums,int k) {
		int[] tmp = new int[k];
		for (int i = nums.length - k,j = 0; i < nums.length; i++,j++) {
			tmp[j] = nums[i];
		}
		
		for (int i = nums.length - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = tmp[i];
		}
	}
	
	/**
	 * 方法二 实现一个方法 每次将数组右移一位  时间复杂度o(nk) 空间复杂度为o(1)
	 * @param nums
	 * @param k
	 */
	public static void solution2(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			rightOnePosition(nums);
		}
	}

	/**
	 * 将数组右移一位
	 * @param nums
	 */
	private static void rightOnePosition(int[] nums) {
		// TODO Auto-generated method stub
		int tmp = nums[nums.length - 1];
		for (int i = nums.length - 1; i > 0; i--) {
			nums[i] = nums[i - 1];
		}
		nums[0] = tmp;
	}
	
	/**
	 * 方法三：将数组分为n-k第一段 k第二段 分别将两段数组reverse 再将整个数组reverse
	 * 时间复杂度o(n) 空间复杂度o(1)
	 * @param nums
	 * @param k
	 */
	public static void solution3(int[] nums, int k) {
		reverseArrays(nums,0,nums.length - k - 1);
		reverseArrays(nums, nums.length - k, nums.length - 1);
		reverseArrays(nums, 0, nums.length - 1);
	}

	private static void reverseArrays(int[] nums, int start, int end) {
		// TODO Auto-generated method stub

		while(start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
	
}
