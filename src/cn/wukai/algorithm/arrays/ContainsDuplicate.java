package cn.wukai.algorithm.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * @author wukai
 *
 */

public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = {4,6,7,11,34,5,4,2};
		System.out.println(solution2(nums));
	}
	
	/**
	 * 1.使用hashset 有重复即返回true 时间复杂度o(n) 空间复杂度o(n)
	 * @param nums
	 * @return
	 */
	public static boolean solution1(int[] nums) {
		if(null == nums || nums.length == 0) {
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}else {
				set.add(nums[i]);
			}
		}
		return false;
	}
	
	/**
	 * 1.先排序，然后遍历数组 看是否有重复
	 * @param nums
	 * @return
	 */
	public static boolean solution2(int[] nums) {
		if(null == nums || nums.length == 0) {
			return false;
		}
		Arrays.sort(nums);
		//quickSort(nums); //手写快排
		for (int i : nums) {
			System.out.print(i + " ");
		}
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

//	private static void quickSort(int[] nums) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
}
