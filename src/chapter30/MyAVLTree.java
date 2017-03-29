package chapter30;

import java.util.Stack;

import temp.BST;

public class MyAVLTree<E extends Comparable<E>> extends BST<E> {
	
	private void balancePath(E e) {
		Stack<TreeNode<E>> stack = findPath(e);
		while (!stack.isEmpty()) {
			AVLTreeNode<E> A = (AVLTreeNode<E>) stack.pop();
//			A.updateHeight();
			
			AVLTreeNode<E> parentOfA = null;
			if (!stack.isEmpty()) {
				parentOfA = (AVLTreeNode<E>) stack.peek();
			}
			int factor = -10;
			switch (balanceFactor(A)) {
			case -2:
				factor = balanceFactor(A.getLeft());
				if (factor == -1 || factor == 0) {
					balanceLL(A, parentOfA);
				}
				else {
					balanceLR(A, parentOfA);
				}
				break;
			case 2:
				factor = balanceFactor(A.getRight());
				if (factor == 1 || factor == 0)
					balanceRR(A, parentOfA);
				else
					balanceRL(A, parentOfA);
				break;
			}
			
			
		}
	}
	
	private void balanceRL(AVLTreeNode<E> a, AVLTreeNode<E> parentOfA) {
		// TODO Auto-generated method stub
		
	}

	private void balanceRR(AVLTreeNode<E> a, AVLTreeNode<E> parentOfA) {
		// TODO Auto-generated method stub
		
	}

	private void balanceLR(AVLTreeNode<E> a, AVLTreeNode<E> parentOfA) {
		// TODO Auto-generated method stub
		
	}

	private void balanceLL(AVLTreeNode<E> A, AVLTreeNode<E> parentOfA) {
		AVLTreeNode<E> B = (AVLTreeNode<E>) A.getLeft();
		
		if (A == root) {
			root = B;
		}
		else {
			if (A == parentOfA.getLeft()) {
				parentOfA.setLeft(A);
			}
			else {
				parentOfA.setRight(B);
			}
		}
		A.setLeft(B.getRight());
		B.setRight(A);
		
		// 先算 A 的
		updateHeight(A);
		updateHeight(B);
		
	}

	private void updateHeight(AVLTreeNode<E> a) {
		// TODO Auto-generated method stub
		
	}

	private int balanceFactor(TreeNode<E> a) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected Stack<TreeNode<E>> findPath(E e) {
		TreeNode<E> current = root;
		Stack<TreeNode<E>> stack = new Stack<>();
		
		while (current != null) {
			
			stack.push(root);
			
			if (e.compareTo(current.getElement()) < 0) {
				current = current.getLeft();
			}
			else if (e.compareTo(current.getElement()) > 0) {
				current = current.getRight();
			}
			else
				break;
		}
		
		if (current != null) {
			return stack;
		}
		
		return null;
	}
	
	
	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		return super.insert(e);
	}
	
	protected AVLTreeNode<E> createNewNode(E e) {
		return new AVLTreeNode<>(e);
	}
	
	
	
	private static class AVLTreeNode<E extends Comparable<E>> extends TreeNode<E> {
		//  高的含义是： 以此节点为root, 到达其所有叶子中，所经过的路径(path)的边数(edges)的最大值
		protected int height;
		
		public AVLTreeNode(E e) {
			super(e);
		}

//		public int updateHeight() {
//			// TODO Auto-generated method stub
//			return;
//		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	}
	
}
