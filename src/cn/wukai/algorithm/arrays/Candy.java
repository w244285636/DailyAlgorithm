package cn.wukai.algorithm.arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 * @author wukai
 *
 */

public class Candy {

	public static int solution(int[] rating) {
		int  n = rating.length;
		int[] nums = new int[n];
		
		//从左到右 从右到左都遍历一次
		for (int i = 1,inc = 1; i < n; i++) {
			if(rating[i] > rating[i - 1]) {
				nums[i] = Math.max(inc++, nums[i]);
			} else {
				inc = 1;
			}
		}
		
		for (int i = n - 2, inc = 1; i >= 0; i--) {
			if(rating[i] > rating[i + 1]) {
				nums[i] = Math.max(inc++, nums[i]);
			} else {
				inc = 1;
			}
		}
		
		int sum = n; //最少一个糖果
		for (int i : nums) {
			sum += i;
		}
		
		return sum;

	}
	
}
