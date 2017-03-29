package niuke;

public class CheckBalance {
	public boolean check(TreeNode root) {
        // write code here
		if (root == null)
			return true;
        boolean[] res = new boolean[1];
        res[0] = true;
        
        getMaxLevel(root, 1, res);
        
        return res[0];
    }
	
	public int getMaxLevel(TreeNode cur, int level, boolean[] isBal) {
		if (cur == null)
			return level;
		
		if (!isBal[0]) {
			return level;
		}
		
		int LL = getMaxLevel(cur.left, level+1, isBal);
		
		if (!isBal[0]) {
			return level;
		}
		
		int RL = getMaxLevel(cur.right, level+1, isBal);
		
		if (Math.abs(LL - RL) > 1) {
			isBal[0] = false;
		}
		
		return Math.max(LL, RL);
	}
}
