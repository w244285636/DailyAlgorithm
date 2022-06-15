package cn.wukai.algorithm.arrays;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,12,1,2,5,0,1,2,3};
		System.out.println(solution(nums, 1));
	}
	
	public static int solution(int[] nums, int target) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != target) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
	
}
