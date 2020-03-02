package com.ttan.binarySearchTree;

/**
 * @Description: 
 * @author ttan
 * @time 2020年1月9日 上午11:21:26
 */
// 二叉搜索树类
public class BinarySearchTree {

	private class Node {
		// 节点类
		int data; // 数据域
		Node right; // 右子树
		Node left; // 左子树

		public Node(int data) {
			super();
			this.data = data;
		}

	}
	private Node root; // 树根节点

	// 插入节点
	public void insert(int key) {

		Node node = new Node(key);

		if (root == null) {
			root = node;
		} else {
			Node parent = null;
			Node cur = root;
			// 本程序没有做key出现相等情况的处理，暂且假设用户插入的节点值都不同
			while (true) {
				parent = cur;
				if (key < cur.data) {
					// 左子树
					cur = cur.left;
					if (cur == null) {
						parent.left = node;
						return;
					}
				} else {
					// 右子树
					cur = cur.right;
					if (cur == null) {
						parent.right = node;
						return;
					}
				}
			}
		}
	}

	// 遍历树 1前序 2中序 3后序
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.println("parentOrder traverse");
			parentOrder(root);
			System.out.println();
			break;
		case 2:
			System.out.println("inOrder traverse");
			inOrder(root);
			System.out.println();
			break;
		case 3:
			System.out.println("postOrder traverse");
			postOrder(root);
			System.out.println();
			break;
		default:
			break;
		}
	}

	// 前序遍历，“根-左-右”
	private void parentOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		parentOrder(root.left);
		parentOrder(root.right);
	}
	// 中序遍历，“左-根-右”
	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	// 后序遍历，“左-右-根”
	private void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	// 查找节点
	public Node find(int key){
		Node cur = root;
		while(cur != null && cur.data != key){
			if(cur.data > key){
				cur = cur.left;
			}else{
				cur = cur.right;
			}
		}
		return cur;
	}
	
	// 删除节点
	public boolean delete(int key) {
		Node cur = root;
		// 父节点
		Node parent = null;
		// 是否为右子树,主要对应为父节点的左或者右
		boolean isRightChild = true;

		while (cur != null && cur.data != key) {
			parent = cur;
			if (key < cur.data) {
				cur = cur.left;
				isRightChild = false;
			} else {
				cur = cur.right;
				isRightChild = true;
			}
		}
		// 未找到需要删除的节点
		if (cur == null) {
			return false;
		}
		// 此时 cur 就是要删除的结点, parent 为其父结点

		// 要删除结点为叶子结点
		if (cur.left == null && cur.right == null) {
			if (cur == root) {
				root = null;// 整棵树清空
			} else {
				// 如果为叶子节点，直接引用为 null
				if (isRightChild) {
					parent.right = null;
				} else {
					parent.left = null;
				}
			}
			return true;
		}
		// 要删除节点有一个子节点
		else if (cur.left == null) {
			if (cur == root) {
				root = root.right;
			} else if (isRightChild) {
				parent.right = cur.right;
			} else {
				parent.left = cur.right;
			}
			return true;
		} else if (cur.right == null) {
			if (cur == root) {
				root = root.left;
			} else if (isRightChild) {
				parent.right = cur.left;
			} else {
				parent.left = cur.left;
			}
			return true;
		} else {// 要删除结点有两个子结点

			// 找到要删除结点的后继结点
			Node successor = getSuccessor(cur);
			if (cur == root) {
				root = successor;
			} else if (isRightChild) {
				parent.right = successor;
			} else {
				parent.left = successor;
			}
			return true;
		}
	}
	
	// 寻找要删除节点的中序后继结点
	private Node getSuccessor(Node delNode) {
		// 中序后继节点父节点
		Node successorParent = delNode;
		// 中序后继节点
		Node successor = delNode;
		// 中序后继，左跟右，所有从右子树开始
		Node cur = delNode.right;

		// 寻找后继节点
		while (cur != null) {
			successorParent = successor;
			successor = cur;
			cur = cur.left;
		}
		// 如果后继结点为要删除结点的右子树的左子，需要预先调整一下要删除结点的右子树
		if (successor != delNode.right) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(39);
        tree.insert(24);
        tree.insert(64);
        tree.insert(23);
        tree.insert(30);
        tree.insert(53);
        tree.insert(60);
        
        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);
        /**
         * print
         * parentOrder traverse
		 * 39 24 23 30 64 53 60 
		 * inOrder traverse
		 * 23 24 30 39 53 60 64 
		 * postOrder traverse
		 * 23 30 24 60 53 64 39
         */
	}
}
