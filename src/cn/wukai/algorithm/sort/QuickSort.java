package cn.wukai.algorithm.sort;

import java.util.Arrays;


/**
 * 快速排序
 * 快排思想就是先标定一个基数，小于该 基数的放在左边，大于该基数的放到右边，然后继续对左右数组排序
 * 如6 1 2 7 9 3 4 5 10 8
 * 基数6 设置i j首尾两个指针，从若j位置小于6 且 i 大于 6 则调换ij位置
 * 第一轮排序下来3 1 2  5 4 6 9 7 10 8
 * @author wukai
 *
 */

public class QuickSort {

	public static void main(String[] args) {
//		int[] nums = {6,1,2,7,9,3,4,5,10,8};
//		for (int i : nums) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		int[] nums = new int[500000];
		int[] copy = new int[500000];
		System.out.println("test....");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50000);
			copy[i] = nums[i];
		}
//		for (int i : nums) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		long startArraySortTime = System.currentTimeMillis();
		Arrays.sort(copy);
		long endArraySortTime = System.currentTimeMillis();
		System.out.println(endArraySortTime - startArraySortTime);
		
//		for (int i : nums) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		long startSortTime = System.currentTimeMillis();
		sort(nums);
		long endSortTime = System.currentTimeMillis();
		System.out.println(endSortTime - startSortTime);
//		for (int i : nums) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		
//		for (int i : nums) {
//			System.out.print(i + " ");
//		}
	}
	
	public static void sort(int[] nums) {
		if(null == nums || nums.length == 0) {
			return;
		}
		
		helpSort(nums,0,nums.length - 1);
	}

	private static void helpSort(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		if(start > end) {
			return;
		}
		int n = nums[start];
		int i = start;
		int j = end;
		while(i < j) {
			while(i < j && nums[j] >= n) {
				--j;
			}
			while(i < j && nums[i] <= n) {
				++i;
			}
			
			if(i < j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		
		//交换位置
		nums[start] = nums[i];
		nums[i] = n;
		
//		if(n > nums[i]) {
//			//int tmp = n;
//			nums[start] = nums[i];
//			nums[i] = n;
//		}
		helpSort(nums, start, i -1);
		helpSort(nums, i + 1, end);
	}
	
	
	
}
