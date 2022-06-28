package cn.wukai.algorithm.arrays;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist 
 * in the array.
 * @author wukai
 *
 */

public class MajorityElement {

	/**
	 * 1.先对数组进行排序 快排o(nlgn)
	 * 2.因为长度超过n/2 那么数组中间这个数必然是major element
	 * @param nums
	 * @return
	 */
	public static int solution1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	/**
	 * 1.可以用抵消思想，凡是和major element不相等的就抵消
	 * 2.剩下的数必然是major element
	 * 3.这里只用遍历一次，时间复杂度o(n)
	 * @param nums
	 * @return
	 */
	public static int solution2(int[] nums) {
		int result = 0;
		int count = 0;
		for (int i : nums) {
			if(count == 0) {
				result = i;
				count = 1;
			} else if(i == result) {
				++count;
			} else if(i != result) {
				--count;
			}
		}
		return result;
	}
	
}
