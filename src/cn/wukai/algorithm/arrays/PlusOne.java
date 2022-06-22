package cn.wukai.algorithm.arrays;

import java.util.Arrays;

/**
 * Given a number represented as an array of digits, plus one to the number.
 * @author wukai
 *
 */

public class PlusOne {

	public static void main(String[] args) {
		int[] digit = {9,9,9,9};
		digit = solution(digit);
		for (int i : digit) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int[] digit) {
		return addNum(digit, 1);
	}

	private static int[] addNum(int[] digit, int num) {
		// TODO Auto-generated method stub
		if(null == digit || digit.length == 0) {
			return null;
		}
		
		int c = num; //进位标志
		for (int i = digit.length - 1; i >= 0; i--) {
			int tmp = digit[i] + c;
			digit[i] = tmp % 10;
			c = tmp / 10;
		}
		
		if(c != 0) {
			int[] newDigit = new int[digit.length + 1];
			System.arraycopy(digit, 0, newDigit, 1, digit.length);
			newDigit[0] = c;
			return newDigit;
		}
		
		return digit;
	}
	
}
