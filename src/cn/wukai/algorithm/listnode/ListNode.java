package cn.wukai.algorithm.listnode;

/**
 * Á´±í
 * @author wukai
 *
 */
public class ListNode {

	public ListNode left;
	public ListNode right;
	public int val;
	
	public ListNode(int val) {
		this.val = val;
	}
	
	public ListNode() {
		
	}
	
	public ListNode(ListNode left,ListNode right, int val) {
		this.left = left;
		this.right = right;
		this.val = val;
	}
	
}
