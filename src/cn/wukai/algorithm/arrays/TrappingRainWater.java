package cn.wukai.algorithm.arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
For example, Given [0,1,0,2,1,0,1,3,2,1,2,1] , return 6.

 * @author wukai
 *
 */

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(solution2(nums));
	}
	
	/**
	 * 对于每个柱子，找到其左右两边最高的柱子，该柱子能容纳的面积就是 min(max_left, max_right) -
height 。所以，
1. 从左往右扫描一遍，对于每个柱子，求取左边最大值；
2. 从右往左扫描一遍，对于每个柱子，求最大右值；
3. 再扫描一遍，把每个柱子的面积并累加。
	 * @param nums
	 * @return
	 */
	public static int solution(int[] nums) {
		
		if(null == nums || nums.length == 0) {
			return 0;
		}
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = 0;
		right[nums.length - 1] = 0;
		//从左往右 
		for (int i = 1; i < nums.length; i++) {
			left[i] = Math.max(left[i - 1], nums[i - 1]);
		}
		
		//从右往左
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], nums[i + 1]);
		}
		
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			int length = Math.min(left[i], right[i]);
			if(length > nums[i]) {
				result += length - nums[i];
			}
		}
		
		return result;
	}
	
	/**
	 * 1.找到最高点，将数组分成两份
	 * 2.从左到最高点
	 * 3.从右到最高点
	 * @param nums
	 * @return
	 */
	public static int solution2(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		int result = 0;
		int maxIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}
		int left = 0;
		for (int i = 0; i < maxIndex; i++) {
			if(nums[i] > left) {
				left = nums[i];
			}else {
				result += left - nums[i];
			}
		}
		int right = 0;
		for (int i = nums.length - 1; i > maxIndex; i--) {
			if(nums[i] > right) {
				right = nums[i];
			}else {
				result += right - nums[i];
			}
		}
		
		return result;
	}
	
}
