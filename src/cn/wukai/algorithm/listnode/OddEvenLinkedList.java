package cn.wukai.algorithm.listnode;

/**
 * 给定一个链表，将奇数节点放一起 偶数节点放一起
 * Example:
 * Given 1->2->3->4->5->NULL ,
 * return 1->3->5->2->4->NULL .
 * @author wukai
 *
 */

public class OddEvenLinkedList {

	public static void main(String[] args) {
		//ListNode l1 = 
	}
	
	/**
	 * 1.设置两个链表 奇数节点放A链表 偶数放B链表 合并两个链表
	 * @param head
	 * @return
	 */
	public static ListNode solution(ListNode head) {
		final ListNode first = new ListNode(-1);
		final ListNode second = new ListNode(-1);
		ListNode firstTmp = first;
		ListNode secondTmp = second;
		int index = 1;
		while(null != head) {
			if(index % 2 != 0) {
				firstTmp.next = head;
				firstTmp = head;
			}else {
				secondTmp.next = head;
				secondTmp = head;
			}
			ListNode tmp = head.next;
			head.next = null; //注意这里需要将节点next置空 不然就无限循环了。
			head = tmp;
			index++;
		}
		
		firstTmp.next = second.next;
		return first.next;
		
		
	}
	
}
