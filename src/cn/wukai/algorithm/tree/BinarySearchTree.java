package cn.wukai.algorithm.tree;

/**
 * 1.二叉搜索树
 * 2.若左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值
 * 3.若右子树不空，则右子树上所有结点的值均大于或等于它的根结点的值
 * 4.左、右子树也分别为二叉排序树
 * 支持对二叉搜索树的插入、删除、查找、前序遍历、中序遍历和后序遍历等操作
 * @author wukai
 *
 */

public class BinarySearchTree<T extends Comparable<T>> {

	private TreeNode<T> root;
	
	private int size;
	
	public BinarySearchTree(){
		this.size = 0;
	}
	/**
	 * 插入value节点
	 * @param data
	 */
	public void insert(T value) {
		TreeNode node = new TreeNode(value);
		add(node);
	}
	
	private void add(TreeNode<T> node) {
		// TODO Auto-generated method stub
		TreeNode<T> current = this.root;
		TreeNode<T> p = null; //记录current父节点
		while(current != null) {
			p = current;
			if(current.value.compareTo(node.value) < 0) {
				current = current.right;
			}else {
				current = current.left;
			}
		}
		node.parent = p;
		if(p == null) {
			this.root = node;
		}else {
			if(p.value.compareTo(node.value) < 0) {
				p.right = node;
			}else{
				p.left  = node;
			}
		}
		this.size++;
	}
	
	/**
	 * 在树中删掉一个值为 value 的节点
	 * @param value
	 */
	public void delete(T value) {
		TreeNode<T> node = search(value);
		if(null != node) {
			delete(node);
		}
	}
	
	/**
	 * 删除node节点
	 * @param node
	 */
	private void delete(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(node.left == null) {
			//左子树为空
			this.transplant(node,node.right);
		}else if(node.right == null) {
			//节点右子树为空
			this.transplant(node, node.left);
		}else {
			//节点有左右两个子树,需要用node的后继节点来代替node
			TreeNode<T> current = this.successor(node);
			if(current.parent != node) {
				this.transplant(current, current.right);
				current.right = node.right;
				current.right.parent = current;
			}
			this.transplant(node, current);
			current.left = node.left;
			current.left.parent = current;
		}
		this.size--;
	}
	
	/**
	 * 在树中用v代替u
	 * 删除子过程
	 * @param u
	 * @param v
	 */
	private void transplant(TreeNode<T> u, TreeNode<T> v) {
		// TODO Auto-generated method stub
		TreeNode<T> parent = u.parent;
		if(null == parent) {
			this.root = v;
		}else if(parent.left == u) {
			parent.left = v;
		}else if(parent.right == u) {
			parent.right = v;
		}
		
		if(v != null) {
			v.parent = u.parent;
		}
	}
	/**
	 * 中序遍历 先左后中再右
	 * @return
	 */
	public String inorderTraversal() {
		return this.inorderTraversal(root);
	}

	private String inorderTraversal(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return "";
		}
		
		String str1 = inorderTraversal(node.left);
		String str = node.value + "\t";
		String str2 = inorderTraversal(node.right);
		return str1+ str + str2;
	}
	
	/**
	 * 前序遍历
	 * @return
	 */
	public String preorderTraversal() {
		return this.preorderTraversal(root);
	}
	
	private String preorderTraversal(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return "";
		}
		String str = node.value + "\t";
		String str1 = preorderTraversal(node.left);
		String str2 = preorderTraversal(node.right);
		return str + str1 + str2;
	}
	
	/**
	 * 后续遍历
	 * @return
	 */
	public String postorderTraversal() {
		return this.postorderTraversal(root);
	}
	private String postorderTraversal(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return "";
		}
		String str1 = postorderTraversal(node.left);
		String str2 = postorderTraversal(node.right);
		String str = node.value + "\t";
		return str1 + str2 + str;
	
	}
	/**
	 *  在二叉搜索树种查找值为 value 的节点
	 * @param value
	 * @return
	 */
	public TreeNode<T> search(T value) {
		return search(root,value);
	}
	private TreeNode<T> search(TreeNode<T> node, T value) {
		// TODO Auto-generated method stub
		TreeNode<T> current  = node;
		while(current != null) {
			if(node.value.compareTo(value) == 0) {
				break;
			}else if(node.value.compareTo(value) < 0) {
				current = current.right;
			}else {
				current = current.left;
			}
			
		}
		
		return current;
	}
	
	/**
	 * 判断是否包含value的节点
	 * @param value
	 * @return
	 */
	public boolean contains(T value) {
		return search(root, value) == null ? false : true;
	}
	
	/**
	 * 查询最小节点
	 * @return
	 */
	public TreeNode<T> mininum(){
		return this.mininum(root);
	}
	private TreeNode<T> mininum(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(null == node) {
			return null;
		}
		TreeNode<T> current = node;
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}
	
	/**
	 * 查询最大节点
	 * @return
	 */
	public TreeNode<T> maxinum(){
		return this.maxinum(root);
	}
	private TreeNode<T> maxinum(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(null == node) {
			return null;
		}
		TreeNode<T> current = node;
		while(current.right != null) {
			current = current.right;
		}
		return current;
	}
	
	/**
	 * 返回 node 的后继节点
	 * 也就是最小的比 node 大的节点
	 * @param node
	 * @return
	 */
	public TreeNode<T> successor(TreeNode<T> node){
		if(null == node) {
			return null;
		}
		TreeNode<T> current = node.right;
		while(current.left != null) {
			current = current.left;
		}
		return current;
	}
	
	/**
	 *  返回 node 节点的前驱节点
	 * 也就是比 node 小的节点中最大的那个
	 * @param node
	 * @return
	 */
	public TreeNode<T> predecessor(TreeNode<T> node){
		if(null == node) {
			return null;
		}
		
		TreeNode<T> current = node.left;
		while(current.right != null) {
			current = current.right;
		}
		return current;
	}
	
}
