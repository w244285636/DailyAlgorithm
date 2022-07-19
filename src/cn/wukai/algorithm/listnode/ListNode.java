package cn.wukai.algorithm.listnode;

/**
 * 单项链表
 * @author wukai
 *
 */
public class ListNode {

	public ListNode next;
	public int val;
	
	public ListNode(int val) {
		this.val = val;
	}
	
	public ListNode() {
		
	}
	
	public ListNode(ListNode next, int val) {
		this.val = val;
		this.next = next;
	}
	
}
