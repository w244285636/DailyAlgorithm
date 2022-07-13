package cn.wukai.algorithm.tree;

/**
 * 1.二叉树节点
 * @author wukai
 *
 */

public class Node {

	Node left;
	Node right;
	int val;
	
	public Node() {
		
	}
	
	public Node(int val) {
		this.val = val;
	}
	
	public void printNode() {
		System.out.println(val);
	}
	
}
