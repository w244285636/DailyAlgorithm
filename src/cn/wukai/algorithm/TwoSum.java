package cn.wukai.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,14};
		int[] ans = solution2(nums, 9);
		for (int i : ans) {
			System.out.println(i);
		}
	}
	
	/**
	 * 暴力解法 o(n2) 超时
	 * @param nums
	 * @param taget
	 * @return
	 */
	public static int[] solution1(int[] nums,int taget) {
		if(null == nums || nums.length < 0) {
			return null;
		}
		int[] ans = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == taget) {
					ans[0] = i + 1;
					ans[1] = j + 1;
					return ans;
				}
			}
		}
		
		return ans;
		
	}
	
	/**
	 * 用hash表记录
	 * @param nums
	 * @param taget
	 * @return
	 */
	public static int[] solution2(int[] nums,int taget) {
		if(null == nums || nums.length < 0) {
			return null;
		}
		int[] ans = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ans.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < ans.length; i++) {
			//int index = taget - nums[i];
			Integer result = map.get(taget - nums[i]);
			if(null != result && i < result) {
				ans[0] = i + 1;
				ans[1] = result + 1;
				return ans; 
			}
		}
		return null;
	}
	
}
