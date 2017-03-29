package niuke;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class TreePrinter {
	public int[][] printTree(TreeNode root) {
		if (root == null)
			return null;
		
		int[][] arrays = new int[500][];
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		int addNum = 1;
		int level = 0;
		
		while (!queue.isEmpty()) {
			int nextAddNum = 0;
			arrays[level] = new int[addNum];
			
			for (int i = 0; i < addNum; i++) {
				TreeNode current = queue.poll();
				arrays[level][i] = current.val;
				if (current.left != null) {
					queue.add(current.left);
					nextAddNum++;
				}
				if (current.right != null) {
					queue.add(current.right);
					nextAddNum++;
				}
			}
			
			addNum = nextAddNum;
			level++;
		}
		
		int[][] result = new int[level][];
		for (int i = 0; i < level; i++)
			result[i] = arrays[i];
		
		return result;
	}
	public static void main(String[] args) {
		String str = "";
	}
	
}
