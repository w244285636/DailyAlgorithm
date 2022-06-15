package cn.wukai.algorithm.arrays;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {1,0,3,0,0,4,5,4};
		nums = solution(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int[] nums) {
		if(null == nums || nums.length == 0) {
			return nums;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[index++] = nums[i];
			}
		}
		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
		return nums;
	}
	
}
