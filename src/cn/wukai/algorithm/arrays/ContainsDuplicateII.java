package cn.wukai.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k ,
 *  find out whether there are two distinct indices i and j
 *  in the array such that nums[i] = nums[j] and the difference
 *  between i and j is at most k
 * @author wukai
 *
 */

public class ContainsDuplicateII {

	public static void main(String[] args) {
		int[] nums = {3,1,4,5,3,4,6,7,1};
		System.out.println(solution(nums, 4));
	}
	
	/**
	 * 使用一个hashMap key存值 value存下表
	 * 当有相同的key计算下标差 若小于等于k直接返回true 否则遍历完数组 返回false
	 * @param nums
	 * @return
	 */
	public static boolean solution(int[] nums,int k) {
		if(null == nums || nums.length == 0) {
			return false;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int index = map.get(nums[i]);
				if(i - index <= k) {
					return true;
				}
			} else {
				map.put(nums[i], i);
			}
		}
		
		return false;
	}
	
}
