package com.ttan.binarySearchTree;

/**
 * @Description: 
 * @author ttan
 * @time 2020��1��9�� ����11:21:26
 */
// ������������
public class BinarySearchTree {

	private class Node {
		// �ڵ���
		int data; // ������
		Node right; // ������
		Node left; // ������

		public Node(int data) {
			super();
			this.data = data;
		}

	}
	private Node root; // �����ڵ�

	// ����ڵ�
	public void insert(int key) {

		Node node = new Node(key);

		if (root == null) {
			root = node;
		} else {
			Node parent = null;
			Node cur = root;
			// ������û����key�����������Ĵ������Ҽ����û�����Ľڵ�ֵ����ͬ
			while (true) {
				parent = cur;
				if (key < cur.data) {
					// ������
					cur = cur.left;
					if (cur == null) {
						parent.left = node;
						return;
					}
				} else {
					// ������
					cur = cur.right;
					if (cur == null) {
						parent.right = node;
						return;
					}
				}
			}
		}
	}

	// ������ 1ǰ�� 2���� 3����
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

	// ǰ�����������-��-�ҡ�
	private void parentOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		parentOrder(root.left);
		parentOrder(root.right);
	}
	// �������������-��-�ҡ�
	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	// �������������-��-����
	private void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	// ���ҽڵ�
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
	
	// ɾ���ڵ�
	public boolean delete(int key) {
		Node cur = root;
		// ���ڵ�
		Node parent = null;
		// �Ƿ�Ϊ������,��Ҫ��ӦΪ���ڵ���������
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
		// δ�ҵ���Ҫɾ���Ľڵ�
		if (cur == null) {
			return false;
		}
		// ��ʱ cur ����Ҫɾ���Ľ��, parent Ϊ�丸���

		// Ҫɾ�����ΪҶ�ӽ��
		if (cur.left == null && cur.right == null) {
			if (cur == root) {
				root = null;// ���������
			} else {
				// ���ΪҶ�ӽڵ㣬ֱ������Ϊ null
				if (isRightChild) {
					parent.right = null;
				} else {
					parent.left = null;
				}
			}
			return true;
		}
		// Ҫɾ���ڵ���һ���ӽڵ�
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
		} else {// Ҫɾ������������ӽ��

			// �ҵ�Ҫɾ�����ĺ�̽��
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
	
	// Ѱ��Ҫɾ���ڵ�������̽��
	private Node getSuccessor(Node delNode) {
		// �����̽ڵ㸸�ڵ�
		Node successorParent = delNode;
		// �����̽ڵ�
		Node successor = delNode;
		// �����̣�����ң����д���������ʼ
		Node cur = delNode.right;

		// Ѱ�Һ�̽ڵ�
		while (cur != null) {
			successorParent = successor;
			successor = cur;
			cur = cur.left;
		}
		// �����̽��ΪҪɾ�����������������ӣ���ҪԤ�ȵ���һ��Ҫɾ������������
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
