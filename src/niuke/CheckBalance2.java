package niuke;

public class CheckBalance2 {
	boolean isBalance = true;
	
	public boolean check(TreeNode root) {
        // write code here
        
        getHeight(root);
        
        return isBalance;
    }
	
	private int getHeight(TreeNode cur) {
        if (cur == null)
            return 0;
        
        if (isBalance) {
            int LH = getHeight(cur.left);
        	
            if (isBalance) {
                int RH = getHeight(cur.right);
                if (Math.abs(LH-RH) > 1) {
                	isBalance = false;
            	}
                
                return Math.max(LH, RH) + 1;
            }   
        }
        
        return -1;
    }
}
