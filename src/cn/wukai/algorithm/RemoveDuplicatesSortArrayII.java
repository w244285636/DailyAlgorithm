package cn.wukai.algorithm;

public class RemoveDuplicatesSortArrayII {

	public static int solution(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		int index = 2;
		for (int i = 2; i < nums.length; i++) {
			if(nums[i] != nums[index -2]) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
	
}
