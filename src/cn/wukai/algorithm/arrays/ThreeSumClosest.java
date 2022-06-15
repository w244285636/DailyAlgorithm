package cn.wukai.algorithm.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int solution(int[] nums, int target) {
		if(null == nums || nums.length < 3) {
			return -1;
		}
		Arrays.sort(nums);
		
		int closest = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k] - target;
				int abs = sum > 0 ? sum : -sum;
				if(abs == 0) {
					return target;
				}
				//closest = closest > abs ? abs : closest;
				if(closest > abs) {
					closest = abs;
					result = nums[i] + nums[j] + nums[k];
				}
				if(sum > 0) {
					--k;
					while(nums[k] == nums[k + 1] && j < k) {
						--k;
					}
				}
				if(sum < 0) {
					++j;
					while(nums[j] == nums[j - 1] && j < k) {
						++j;
					}
				}
			}
		}
		
		return result;
	}
	
}
