package niuke;
import java.util.*;

public class TreeToSequence {
	
	public int[] preOrder(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return listToArray(list);
    }
    
    public int[] inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            
            while (!stack.isEmpty()) {
                cur = stack.pop();
                list.add(cur.val);
                
                if (cur.right != null) {
                    stack.push(cur.right);
                    break;
                }
            }
        }
        return listToArray(list);
    }
    
    public int[] postOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        s1.push(root);
        
        while (!s1.isEmpty()) {
            TreeNode cur = s1.pop();
            if (cur.left != null)
                s1.push(cur.left);
            
            if (cur.right != null)
                s1.push(cur.right);
            
            s2.push(cur);
        }
        
        while (!s2.isEmpty()) {
            list.add((s2.pop()).val);
        }
        
        return listToArray(list);
    }
    
    public static int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
