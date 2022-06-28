package cn.wukai.algorithm.listnode;

import java.util.HashMap;
import java.util.Map;


/**
 * 1.用HashMap和双向链表来实现一个缓存
 * 2.查询o(1),插入删除o(1)
 * @author wukai
 *
 */

public class LurCache {

	private int capacity;
	private Map<Integer, Node> map;
	private Node head;
	private Node end;
	
	public LurCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, LurCache.Node>();
	}
	
	/**
	 * 获取key缓存的value
	 * @param key
	 * @return
	 */
	public int get(int key) {
		if(map.containsKey(key)) {
			
			Node node = map.get(key);
			remove(node);
			setHead(node);
			
			return node.value;
		} else {
			return -1;
		}
	}
	
	public void put(int key,int value) {
		if(map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node newNode = new Node(key, value);
			if(map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(newNode);
			} else {
				
				setHead(newNode);
			}
			map.put(key, newNode);
		}
	}
	
	/**
	 * 将使用后的node置于链表头
	 * @param node
	 */
	private void setHead(Node node) {
		// TODO Auto-generated method stub
		node.next = head;
		node.prev = null;
		
		if(null != head) {
			head.prev = node;
		}
		
		head = node;
		if(null == end) {
			end = head;
		}
	}

	/**
	 * 删除链表节点
	 * @param node
	 */
	private void remove(Node node) {
		// TODO Auto-generated method stub
		if(null != node.prev) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}
		
		if(null != node.next) {
			node.next.prev = node.prev;
		} else {
			end = node.prev;
		}
	}

	//双向链表
	static class Node{
		int key;
		int value;
		Node prev;
		Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	
	
}


