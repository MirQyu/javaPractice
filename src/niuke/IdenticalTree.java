package niuke;

import java.util.Stack;


public class IdenticalTree {
	public boolean chkIdentical(TreeNode A, TreeNode B) {
	       
        String strA = preorderTraversal(A);
        String strB = preorderTraversal(B);
        
        if (strA.contains(strB))
        	return true;
        else
        	return false;
        
    }
	
	public String preorderTraversal(TreeNode head) {
		 StringBuilder builder = new StringBuilder();
		 
		 Stack<MyNode> stack = new Stack<>();
		 if (head != null) {
			 stack.push(new MyNode(head));
		 }
		 
		 while (!stack.isEmpty()) {
			 MyNode current = stack.peek();
			 
			 if (!current.pushLeft) {
				 builder.append(current.node.val + " ");
				 current.pushLeft = true;
				 
				 if (current.node.left != null) {
					 stack.push(new MyNode(current.node.left));
				 }
				 else {
					 builder.append("# ");
				 }
			 }
			 else {
				 stack.pop();
				 if (current.node.right != null) {			 
					 stack.push(new MyNode(current.node.right));
				 }
				 else {
					 builder.append("# ");
				 }
			 }
		 }
		 
		 return builder.toString();
	}
	
	static class MyNode {
		 TreeNode node;
		 boolean pushLeft;
		 public MyNode(TreeNode node) {
			this.node = node;
		}
	 }
	
	class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
}
