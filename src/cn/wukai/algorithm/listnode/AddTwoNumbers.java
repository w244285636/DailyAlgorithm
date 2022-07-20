package cn.wukai.algorithm.listnode;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author wukai
 *
 */

public class AddTwoNumbers {

	public static ListNode solution(ListNode first,ListNode second) {
	
		ListNode addList = new ListNode(0);
		
		ListNode prev = addList;
		int carry = 0;
		
		for (; first != null || second != null;
				first = first == null ? null : first.next,
					second = second == null ?null : second.next,
					prev = prev.next) {
			int firstVal = first == null ? 0 : first.val;
			int secondVal = second == null ? 0 : second.val;
			int val = (firstVal + secondVal + carry) % 10;
			carry =  (firstVal + secondVal + carry) / 10;
			prev.next = new ListNode(val);
		}
		if(carry != 0) {
			prev.next = new ListNode(carry);
		}
		
		return addList.next;
		
	}
	
}
