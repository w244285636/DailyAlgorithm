package cn.wukai.algorithm.listnode;

/**
 * Given a sorted linked list, delete all duplicates such that
 *  each element appear only once.
 *  For example,
 *  Given 1->1->2 , return 1->2 .
 *  Given 1->1->2->3->3 , return 1->2->3 .
 * @author wukai
 *
 */

public class RemoveDuplicatesfromSortedList {

	public static ListNode solution(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		while(head != null && head.next != null) {
			if(head.val == head.next.val) {
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
		
		return dummy.next;
	}
	
}
