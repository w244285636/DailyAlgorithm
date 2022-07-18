package cn.wukai.algorithm.tree;

/**
 * 1.二叉树节点
 * @author wukai
 *
 */

public class TreeNode<T extends Comparable<T>> {

	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	public T value;
	
	
	public TreeNode() {
		
	}
	
	public TreeNode(T val) {
		this.value = val;
	}
	
	public void printNode() {
		System.out.println(value);
	}
	
}
