package cn.wukai.algorithm.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = {100,2,4,5,6,101,50,47,48,51,52,53,49};
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i : nums) {
			set.add(i);
		}
		int longest = 0;
		for (int i : nums) {
			int length = 1;
			for (int j = i - 1; set.contains(j); --j) {
				set.remove(j);
				length++;
			}
			for (int j = i + 1; set.contains(j); ++j) {
				set.remove(j);
				length++;
			}
			longest = longest > length ? longest : length;
		}
		
		return longest;
	}
	
}
