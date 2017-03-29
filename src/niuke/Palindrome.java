package niuke;

import java.util.Stack;


public class Palindrome {
	public boolean isPalindrome(ListNode pHead) {
        // write code here
		if (pHead == null)
			return true;
		
        Stack<Integer> stack = new Stack<>();
        ListNode cur = pHead, twoStepNode = pHead;
        
        
        while (twoStepNode != null && twoStepNode.next != null && twoStepNode.next.next != null) {
        	
        	stack.push(cur.val);
        	twoStepNode = twoStepNode.next.next;
        	cur = cur.next;
        }
        
        
        if (twoStepNode.next != null) {
     	   stack.push(cur.val);
        }
       
       cur = cur.next;
       
       while (cur != null) {
    	   int val = stack.pop();
    	   if (cur.val != val)
    		   return false;
    	   cur = cur.next;
       }
        
        return true;
        
    }
}
