package cn.wukai.algorithm.listnode;

/**
 * 双向链表
 * @author wukai
 *
 */

public class DoublyListNode<T> {

	public DoublyListNode<T> next;
	
	public DoublyListNode<T> prev;
	
	public T val;
	
	public DoublyListNode(T val){
		this.val = val;
	}
	
	public DoublyListNode(DoublyListNode<T> prev, DoublyListNode<T> next, T val) {
		this.next = next;
		this.prev = prev;
		this.val = val;
	}
	
}
