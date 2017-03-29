package chapter25;

import java.util.ArrayList;

import chapter30.AVLTree;
import chapter30.BST;
import javafx.application.Application;

public class TestBST {
	static Integer[] numbers = {60, 55, 100, 45, 57, 67, 107, 59, 101};
	static BST<Integer> intTree = new AVLTree<>(numbers);
	public static void main(String[] args) {
		System.out.print("\npreorder (sorted): ");
//		intTree.preorder();
		intTree.preorderIteration();
//		System.out.println("\n");
//		System.out.println(intTree.getNumberOfLeaves());
		System.out.println("递归版本的深度： " + intTree.getHeightRecursion());
		System.out.println("迭代版本的深度： " + intTree.getHeightIteration());
		Application.launch(BSTAnimation.class, args);
		
	}
	
	
	public static<E extends Comparable<E>> BST<E> getTree() {
		return (BST<E>) intTree;
	}
	
	public static void test() {
		BST<String> tree = new BST<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		int depth = tree.getHeightIteration();
		System.out.println(depth);
		System.out.println(tree.getSize());
		System.out.println((int)Math.pow(2, depth) - 1);
		
		
//		System.out.print("Inorder (sorted): ");
//		tree.inorder();
//		System.out.print("\nPostorder: ");
//		tree.postorder();
//		System.out.println("\nPreorder: ");
//		tree.preorder();
//		System.out.println("\nThe number of nodes is " + tree.getSize());
//		
//		System.out.print("\nIs Peter in the tree? " + tree.search("Peter"));
//		
//		System.out.print("\nA path from the root to Peter is: ");
//		java.util.ArrayList<BST.TreeNode<String>> path = tree.path("Peter");
//		for (int i = 0; path != null && i < path.size(); i++)
//			System.out.print(path.get(i).element + " ");
		
//		Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
		
	}
}
