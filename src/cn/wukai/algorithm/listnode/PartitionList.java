package cn.wukai.algorithm.listnode;

/**
 * Given a linked list and a value x , partition it such that all nodes 
 * less than x come before nodes greater than or equal to x .
 * You should preserve the original relative order of the nodes 
 * in each of the two partitions.
 * For example, Given 1->4->3->2->5->2 and x = 3 , return 1->2->2->4->3->5 .
 * @author wukai
 *
 */

public class PartitionList {

	public static ListNode solution(ListNode head,int k) {
		ListNode left = new ListNode(-1);
		ListNode right = new ListNode(-1);
		//left.next = head;
		ListNode tmpLeft = left;
		ListNode tmpRight = right;
		while(head != null) {
			if(head.val < k) {
				tmpLeft.next = head;
				tmpLeft = tmpLeft.next;
			}else {
				tmpRight.next = head;
				tmpRight = tmpRight.next;
			}
			head = head.next;
		}
		
		tmpLeft.next = right.next;
		tmpRight = null;
		
		return left;
	}
	
}
