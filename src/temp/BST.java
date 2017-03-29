package temp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import chapter25.AbstractTree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {

	
	protected TreeNode<E> root;
	protected int size = 0;
	
//	private int height = -1;
	private int leaves = 0;
	
	public BST() {
	}
	
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}
	
	public int getNumberOfLeaves() {
		if (root == null) return 0;
		leaves = 0;
		
		leaves(root);
		return leaves;
	}
	
	public void leaves(TreeNode<E> current) {
		if (current.left != null) {
			leaves(current.left);
		}
		
		if (current.right != null) {
			leaves(current.right);
		}
		if (current.left == null && current.right == null)
			leaves++;
	}
	
	public int getHeightIteration() {
		return heightIteration(root);
	}
	
	/**
	 * 迭代版本 算 BFT
	 * @return
	 */
	public int heightIteration(TreeNode<E> root) {
		
		if (root == null) {
			return -1;
		}
		
		int depth = -1;
		TreeNode<E> current = root;
		Queue<TreeNode<E>> queue = new LinkedList<>();
		queue.add(current);
		int nextLevelNum = 1;
		
		while (!queue.isEmpty()) {
			depth++;
			int pushNum = 0;
			for (int i = 0; i < nextLevelNum; i++) {
				current = queue.remove();
				if (current != null) {
					if (current.left != null) {
						queue.add(current.left);
						pushNum++;
					}
					if (current.right != null) {
						queue.add(current.right);
						pushNum++;
					}
				}
			}
			nextLevelNum = pushNum;
		}
		
		return depth;
		
	}
	
	public int getHeightRecursion() {
		
		if (root != null) {
			return heightRecursion(root, 0);
		}
		else {
			return -1;
		}
		
	}
	
	public int heightRecursion(TreeNode<E> current, int currentHeight) {
		System.out.printf("current = %s, depth = %d\n", current.element, currentHeight);
		// 叶子节点返回
		if (current.left == null && current.right == null) {
			return currentHeight;
		}
		
		int leftHeight = 0, rightHeight = 0;
		
		if (current.left != null) {
			leftHeight = heightRecursion(current.left, currentHeight + 1);
		}
		
		if (current.right != null) {
			rightHeight = heightRecursion(current.right, currentHeight + 1);
		}
		
		return (leftHeight < rightHeight) ? rightHeight : leftHeight;
		
	}
	
	@Override
	public boolean search(E e) {
		TreeNode<E> current = root;
		
		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				current = current.right;
			}
			else
				return true;
		}
		
		return false;
	}

	@Override
	public boolean insert(E e) {
		if (root == null)
			root = createNewNode(e);
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				}
				else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}
				else
					return false;	// 重复的不插入
			}
			
			if (e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}
		
		size++;
		return true;
	}
	
	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<>(e);
	}
	
	@Override
	public void inorder() {
		inorder(root);
	}

	protected void inorder(TreeNode<E> root) {
		if (root == null) return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}
	
	@Override
	public void postorder() {
		postorder(root);
	}

	protected void postorder(TreeNode<E> root) {
		if (root == null) return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	
	public void preorderIteration() {
		Stack<TreeNode<E>> stack = new Stack<>();
		TreeNode<E> current = root;
		if (current != null) {
			stack.push(current);
		}
		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(current.element + " ");
			
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}
	
	@Override
	public void preorder() {
		preorder(root);
	}
	
	
	protected void preorder(TreeNode<E> root) {
		if (root == null) 
			return;
		
		System.out.print(root.element + " ");
//		System.out.flush();
		preorder(root.left);
		preorder(root.right);
	}
	
	/**
	 * ！不需要访问外部实例成员，因此 static
	 * @author MirQ
	 *
	 * @param <E>
	 */
	public static class TreeNode<E extends Comparable<E>> {
		protected E element;
		protected TreeNode<E> left;
		protected TreeNode<E> right;
		
		
		public E getElement() {
			return element;
		}


		public void setElement(E element) {
			this.element = element;
		}


		public TreeNode<E> getLeft() {
			return left;
		}


		public void setLeft(TreeNode<E> left) {
			this.left = left;
		}


		public TreeNode<E> getRight() {
			return right;
		}


		public void setRight(TreeNode<E> right) {
			this.right = right;
		}


		public TreeNode(E e) {
			element = e;
		}
	}
	
	
	@Override
	public int getSize() {
		return size;
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}
	
	/**
	 * include the node containing the e
	 * @param e
	 * @return
	 */
	public java.util.ArrayList<TreeNode<E>> path(E e) {
		java.util.ArrayList<TreeNode<E>> list =
				new java.util.ArrayList<>();
		TreeNode<E> current = root;
		
		while (current != null) {
			
			list.add(current);
			
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				current = current.right;
			}
			else 
				break;
		}
		
		return list;
	}
	
	@Override
	/**
	 * 删除element
	 * 2类 case， without left node. 
	 * the other.
	 */
	public boolean delete(E e) {
		// locate the node to be deleted and also locate its parent node
		// 常用代码块， 查找element, and its parent
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while(current != null) {
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			}
			else
				break;
		}
		
		if (current == null)
			return false;
		
		// Case 1: current has no left child
		if (current.left == null) {
			// Connect the parent with the right child of the current node
			if (parent == null) {	// current == root
				root = current.right;
			}
			else {
				if (e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}
		// Case 2: the current node has a left child
		// Locate the rightmost node in the left subtree of
		// the current node and also its parent
		else {
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			
			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;
			
			if (parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case:
				parentOfRightMost.left = rightMost.left;
		}
		
		size--;
		return true;
	}
	
	@Override
	public java.util.Iterator<E> iterator() {
		return new InorderIterator();
	}
	
	// Inner class
	private class InorderIterator implements java.util.Iterator<E> {
		private java.util.ArrayList<E> list = new ArrayList<>();
		private int current = 0;
		
		public InorderIterator() {
			inorder();
		}
		
		private void inorder() {
			inorder(root);
		}

		private void inorder(TreeNode<E> root) {
			if (root == null) return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		@Override
		public boolean hasNext() {
			if (current < list.size())
				return true;
			
			return false;
		}

		@Override
		public E next() {
			return list.get(current++);
		}

		@Override
		public void remove() {
			delete(list.get(current));
			list.clear();
			inorder();
		}
	}
	
	public void clear() {
		root = null;
		size = 0;
	}
}
