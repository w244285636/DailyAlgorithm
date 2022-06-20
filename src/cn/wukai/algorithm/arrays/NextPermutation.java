package cn.wukai.algorithm.arrays;

/**
 * 实现下一个排列，将数字重新排列为按字典顺序排列的下一个更大的数字排列。
 *如果无法进行这种排列，则必须将其重新排列为尽可能低的顺序（即，按升序排序）。
 * @author wukai
 *
 */
public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = {6,8,7,4,3,2};
		//int[] nums = {8,5,4,2,1};
		solution(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * ex： 6 8 7 4 3 2 
	 * 1.从右到左 找到非升序数 6
	 * 2.从右到左 找到大于上步骤中的数 7
	 * 3.交换1 2步骤中数据 7 8 6 4 3 2
	 * 			      0 1 2 3 4 5
	 * 4.将7后数字 反转 7 2 3 4 6 8
	 * @param nums
	 * @return
	 */
	public static int[] solution(int[] nums) {
		if(null == nums || nums.length == 0) {
			return nums;
		}
		int left = 0;
		int right = 0;
		//find left;
//		for (int i = nums.length - 1; i >= 0; i--) {
//			if(i != 0 && nums[i - 1] < nums[i]) {
//				left = i - 1;
//				break;
//			}
//			if(i == 0 && nums[i] < nums[])
//		}
		int p = nums.length - 2;
		while(p > -1 && nums[p] >= nums[p + 1]) --p;
		
		if(p == -1) {
			//已经最大倒序排序
			return reverseNums(nums, 0, nums.length - 1);
		}
		left = p;
		System.out.println("left" + left);
		//find right
		for (int i = nums.length -1; i >= 0; i--) {
			if(nums[i] > nums[left]) {
				right = i;
				break;
			}
		}
		System.out.println("right" + right);
		//swap left right
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
		
		//reorder nums
		return reverseNums(nums, left + 1, nums.length - 1);
	}
	
	/**
	 * 将数组left至right反转
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] reverseNums(int[] nums, int left, int right) {
		if(right == left) {
			return nums;
		}
		if(left > right) {
			return reverseNums(nums, right, left);
		}
		int length = right - left + 1;
		for (int i = left, j = right; i < left + length / 2; i++,j--) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		return nums;
	}
	
}
