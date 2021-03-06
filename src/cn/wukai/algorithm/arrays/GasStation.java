package cn.wukai.algorithm.arrays;

/**
 * There are N gas stations along a circular route, 
 * where the amount of gas at station i is gas[i] .
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel 
 * from station i to itsnext station ( i+1 ).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once,
 * otherwise return -1.
 * Note: The solution is guaranteed to be unique.
 * @author wukai
 *
 */

public class GasStation {

	/**
	 * O(N) 的解法是，设置两个变量， sum 判断当前的指针的有效性； 
	 * total 则判断整个数组是否有解，有就返回通过 sum 得到的下标，没有则返回-1。
	 */
	public static int solution(int[] gas, int[] cost) {
		int total = 0;
		int j = -1;
		for (int i = 0, sum = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if(sum < 0) {
				sum = 0;
				j = i ;
			}
		}
		return total >= 0 ? j + 1 : -1;
	}
	
}
