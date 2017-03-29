package niuke;

public class CountNodes {
	
	public static void main(String[] args) {
		System.out.println(1 << 0);
	}
	public int count(TreeNode root) {
        // write code here
        return f(root); 
    }

	public int f(TreeNode root) {
		int deep = getLeftDeep(root);
		
		if (deep == 0)
			return 0;
		
		if (deep == 1)
			return 1;
		
		int leftDeep = deep - 1;
		int rightDeep = getLeftDeep(root.right);
		
		if (rightDeep == leftDeep) {
			return (int)(Math.pow(2, leftDeep) + 0.5) + f(root.right);
		}
		
		else{
			return (int)(Math.pow(2, rightDeep) + 0.5) + f(root.left);
		}
		
		// deep-1 左子树深度
		// 位移运算符的优先级
//		if (rightDeep == leftDeep) {
//			return (1 << leftDeep) + f(root.right);
//		}
//		
//		else{
//			return (1 << rightDeep) + f(root.left);
//		}
	}
	
	public int getLeftDeep(TreeNode node) {
		int deep = 0;
		
		while (node != null) {
			deep++;
			node = node.left;
		}
		
		return deep;
	}
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
}


