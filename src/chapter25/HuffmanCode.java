package chapter25;

import java.util.Scanner;

import chapter25.HuffmanCode.Tree.Node;

public class HuffmanCode {
	public static void main(String[] args) {
		System.out.printf("%-15d\n", 15);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = input.nextLine();
		
		// 256 ASCII
		int[] counts = getCharacterFrequency(text);
		
		System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");
		
		Tree tree = getHuffmanTree(counts);
		String[] codes = getCode(tree.root);
		
		for (int i = 0; i < codes.length; i++)
			if (counts[i] != 0)
				System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char)i + "", counts[i], codes[i]);
	}
	
	public static int[] getCharacterFrequency(String text) {
		int[] counts = new int[256];
		
		for (int i = 0; i < text.length(); i++) {
			counts[(int)text.charAt(i)]++;
		}
		
		return counts;
	}
	
	// 一种生成哈夫曼树的 方法
	public static Tree getHuffmanTree(int[] counts) {
		Heap<Tree> heap = new Heap<>();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0) {
				heap.add(new Tree(counts[i], (char)i));
			}
		}
		
		while (heap.getSize() > 1) {
			Tree t1 = heap.remove();
			Tree t2 = heap.remove();
			heap.add(new Tree(t1, t2));
		}
		
		return heap.remove();
	}
	
	public static String[] getCode(Tree.Node root) {
		if (root == null) return null;
		String[] codes = new String[2 * 128];
		assignCode(root, codes);
		return codes;
	}
	
	/**
	 * 
	 * @param root
	 * @param codes 保存字符 的最终编码 encode
	 */
	private static void assignCode(Node root, String[] codes) {
		if (root.left != null) {
			root.left.code = root.code + "0";
			assignCode(root.left, codes);
			
			root.right.code = root.code + "1";
			assignCode(root.right, codes);
		}
		else {
			codes[(int)root.element] = root.code;
		}
	}

	/**
	 * static 这里静态的作用需要注意！, 此处内部类 不需要访问外部实例成员
	 * @author MirQ
	 */
	public static class Tree implements Comparable<Tree> {
		Node root;
		
		/**
		 * 这个构造函数起到 连接子树，从而形成更大的树
		 * @param t1
		 * @param t2
		 */
		public Tree(Tree t1, Tree t2) {
			root = new Node();
			root.left = t1.root;
			root.right = t2.root;
			root.weight = t1.root.weight + t2.root.weight;
		}
		
		/**
		 * 初始化最小的树， 即 “树叶”
		 * @param weight
		 * @param element
		 */
		public Tree(int weight, char element) {
			root = new Node(weight, element);
		}
		
		// 由于这里使用的是 最大堆， 所以这里reverse the order
		@Override
		public int compareTo(Tree t) {
			if (root.element < t.root.element) 
				return -1;
			else if (root.element == t.root.element)
				return 0;
			else
				return 1;
		}
	
		public class Node {
			char element;
			int weight;
			Node left;
			Node right;
			String code = "";
			
			public Node() {
			}
			
			public Node(int weight, char element) {
				this.weight = weight;
				this.element = element;
			}
			
		}
	}
}
