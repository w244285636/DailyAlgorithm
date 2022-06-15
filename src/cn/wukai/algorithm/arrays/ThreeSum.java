package cn.wukai.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,4};
		List<List<Integer>> ans = solution(nums);
		for (List<Integer> list : ans) {
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> solution(int[] nums){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(null == nums || nums.length < 3) {
			return ans;
		}
		Arrays.sort(nums);
		int target = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			if(nums[i] > 0) {
				break;
			}
			int j = i + 1;
			int k = nums.length - 1;
			while(j < k) {
				if(nums[i] + nums[j] + nums[k] < target) {
					++j;
					while(nums[j] == nums[j - 1] && j < k) {
						++j;
					}
				}
				if(nums[i] + nums[j] + nums[k] > target) {
					--k;
					while(nums[k] == nums[k + 1] && j < k) {
						--k;
					}
				}
				if(nums[i] + nums[j] + nums[k] == target) {
					ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
					++j;
					--k;
					while(nums[j] == nums[j - 1] && j < k) {
						++j;
					}
					while(nums[k] == nums[k + 1] && j < k) {
						--k;
					}
				}
			}
		}
		
		return ans;
	}
	
}
