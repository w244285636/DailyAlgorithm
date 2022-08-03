package cn.wukai.algorithm.listnode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->nullptr and k = 2 , return 4->5->1->2->3->nullptr
 * @author wukai
 *
 */

public class RotateList {

	/**
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode solution(ListNode head,int k) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		int len = 0;
		while(cur != null && cur.next != null) {
			len++;
			cur = cur.next;
		}
		len++;
		cur.next = head;
		
		k %= len;
		ListNode tmp = head;
		
		for (int i = 1; i < len - k; i++) {
			tmp = tmp.next;
		}
		
		ListNode result = tmp.next;
		tmp.next = null;
		return result;
	}
	
}
