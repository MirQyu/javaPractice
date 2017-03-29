package niuke;

import java.util.ArrayList;


public class Common {
	public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        
        ListNode curA = headA, curB = headB;
        
        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                curA = curA.next;
            }
            else if (curB.val < curA.val) {
                curB = curB.next;
            }
            else {
                list.add(curA.val);
                curA = curA.next;
                curB = curB.next;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; ++i)
        	ans[i] = list.get(i);
        
        return ans;
        
    }
	
	public static void main(String[] args) {
		int i = 5, j = i;
		
		System.out.println(i + "    " + j);
	}
}
