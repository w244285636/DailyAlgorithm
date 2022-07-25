package cn.wukai.algorithm.listnode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5 , return 1->2->5 .
 * Given 1->1->1->2->3 , return 2->3 .
 * @author wukai
 *
 */

public class RemoveDuplicatesfromSortedListII {

	/**
	 * 递归版本
	 * @param head
	 * @return
	 */
	public static ListNode solution(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode p = head.next;
		if(head.val == p.val) {
			while(p != null && p.val == head.val) {
				p = p.next;
			}
			return solution(p);
		}else {
			head.next = solution(head.next);
			return head;
		}
	}
	
}
