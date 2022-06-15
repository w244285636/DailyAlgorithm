package cn.wukai.algorithm.arrays;

public class RemoveDuplicatesSortArrayI {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,3,4,5,6,6,7};
		solution(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public static int solution(int[] nums) {
		if(null == nums || nums.length == 0) {
			return 0;
		}
		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[index - 1]) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
	
}
