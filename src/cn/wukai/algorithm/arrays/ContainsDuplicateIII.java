package cn.wukai.algorithm.arrays;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct 
 * indices i and j in the array such that the difference 
 * between nums[i] and nums[j] is at most t and the difference 
 * between i andj is at most k .
 * @author wukai
 *
 */

public class ContainsDuplicateIII {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(4);
		set.add(5);
		for (Integer integer : set) {
			System.out.print(integer + " ");
		}
		System.out.println();
		System.out.println(set.floor(2));
		System.out.println(set.ceiling(2));
	}
	
	public static boolean solution(int[] nums,int k ,int t) {
		if(null == nums || nums.length == 0 || k < 0 || t < 0) {
			return false;
		}
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			Integer ceiling = set.ceiling(x); 
			Integer floor  = set.floor(x);
			
			if((ceiling != null && t >= ceiling - x) 
					|| (floor != null && t >= x - floor)) {
				return true;
			}
			set.add(x);
			if(i >= k) {
				set.remove(nums[i - k]);
			}
		}
		
		return false;
	}
	
}
