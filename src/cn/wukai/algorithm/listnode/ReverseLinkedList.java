package cn.wukai.algorithm.listnode;

/**
 * Reverse a singly linked list.
 * @author wukai
 *
 */

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		ListNode l = solution2(l1);
		
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}
		
	}
	
	public static ListNode solution(ListNode head) {
		if(null == head || null == head.next ) {
			return head;
		}
		ListNode tail = null;
		ListNode next = head.next;
		ListNode prev = head;
		prev.next = tail;
		while( null != next) {
			ListNode tmp = next.next;
			
			//prev.next = tail;
			next.next = prev;
			
			//tail = prev;
			prev = next;
			next = tmp;
		}
		return prev;
	}
	
	/**
	 * 递归
	 */
	public static ListNode solution2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode tail = head.next;
		head.next = null;
		ListNode newHead = solution2(tail);
		tail.next = head;
		
		return newHead;
	}
}
