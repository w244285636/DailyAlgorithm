package cn.wukai.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {

	/**
	 * 直接暴力夹逼算法
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> solution(int[] nums,int target){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(null == nums || nums.length < 4) {
			return ans;
		}
		//先排序
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if(nums[j] == nums[j - 1]) continue;
				int m = j + 1;
				int n = nums.length - 1;
				while(m < n) {
					if(nums[i] + nums[j] + nums[m] + nums[n] < target) {
						++m;
						while(m < n && nums[m] == nums[m -1]) {
							++m;
						}
					}
					if(nums[i] + nums[j] + nums[m] + nums[n] > target) {
						--n;
						while(m < n && nums[n] == nums[n + 1]) {
							--n;
						}
					}
					if(nums[i] + nums[j] + nums[m] + nums[n] == target) {
						List<Integer> list = Arrays.asList(nums[i],nums[j], nums[m], nums[n]);
						ans.add(list);
						++m;
						--n;
						while(m < n && nums[m] == nums[m - 1]) {
							++m;
						}
						while(m < n && nums[n] == nums[n + 1]) {
							--n;
						}
					}
				}
			}
		}
		
		return ans;
	}
	
	/**
	 * 使用哈希表记录
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> solution2(int[] nums, int target){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if(null == nums || nums.length < 4) {
			return ans;
		}
		Arrays.sort(nums);
		Map<Integer, List<int[]>> cache = new HashMap<Integer, List<int[]>>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				List<int[]> list = cache.get(nums[i] + nums[j]);
				if(list == null) {
					list = new ArrayList<int[]>();
					int[] tmps = {i,j};
					list.add(tmps);
					cache.put(nums[i] + nums[j], list);
				}else {
					int[] tmps = {i,j};
					list.add(tmps);
				}
			}
		}
		
		Set<String> used = new HashSet<String>();
		for (int i = 0; i < nums.length - 1; i++) {
			if(i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[j] == nums[j - 1]) continue;
				List<int[]> list = cache.get(target - nums[i] - nums[j]);
				if(null != list) {
					for (int[] pairs : list) {
						if(j >= pairs[0]) continue;
						int[] col = {nums[i], nums[j], nums[pairs[0]],nums[pairs[1]]};
						Arrays.sort(col);
						String key = Arrays.toString(col);
						if(!used.contains(key)) {
							used.add(key);
							List<Integer> result = Arrays.asList(nums[i], nums[j], nums[pairs[0]],nums[pairs[1]]);
							ans.add(result);
						}
					}
				}
			}
		}
		
		return ans;
	}
	
}
