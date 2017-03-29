package niuke;

import java.util.Stack;

public class Solution {
//	Stack<Integer> stackData = new Stack<>();
//	Stack<Integer> stackMin = new Stack<>();
//	
//	public void push(int node) {
//        stackData.push(node);
//        
//        if (stackMin.isEmpty()) {
//        	stackMin.push(node);
//        }
//        else {
//        	int min = stackMin.peek();
//        	if (node <= min)
//        		stackMin.push(node);
//        }
//    }
//    
//    public void pop() {
//    	if (stackData.isEmpty())
//    		throw new RuntimeException("stack is empty!");
//    	
//        int top = stackData.pop();
//        if (top == stackMin.peek()) {
//        	stackMin.pop();
//        }
//    }
//    
//    public int top() {
//        return stackData.peek();
//    }
//    
//    public int min() {
//        return stackMin.peek();
//    }
    
    public static void main(String[] args) {
    	RandomListNode r1 = new RandomListNode(1);
    	RandomListNode r2 = new RandomListNode(2);
    	RandomListNode r3 = new RandomListNode(3);
    	r1.next = r2;
    	r2.next = r3;
    	r1.random = r3;
    	r2.random = r1;
    	r3.random = r2;
    	
    	
    	for (RandomListNode cur = r1; cur != null; cur = cur.next) {
    		System.out.println("cur = " + cur);
    		
    	}
    	
    	Solution sol = new Solution();
    	System.out.println("--------------------------");
    	RandomListNode dupHead = sol.Clone(r1);
    	
	}
    
    public RandomListNode Clone(RandomListNode pHead)
    {
    	
    	RandomListNode cur = pHead, dupCur = null;
    	// generate new node and link it with original
    	while (cur != null) {
    		dupCur = new RandomListNode(cur.label);
    		link(cur, dupCur);
    		cur = dupCur.next;
    	}
  
    	// supply the random 
    	dupCur = null;
    	cur = pHead;
    	while (cur != null) {
    		dupCur = cur.next;
    		
    		dupCur.random = (cur.random == null) ? null : cur.random.next;
    		cur = dupCur.next;
    	}
    	
    	// separate 
    	cur = pHead;
    	RandomListNode dupHead = null, lastNode = null;;
    	
    	while (cur != null) {
    		if (dupHead == null) {
    			dupHead = cur.next;
    		}
    		else {
    			lastNode.next = cur.next;
    		}
    		
    		lastNode = cur.next;
    		cur.next = lastNode.next;
    		
    		cur = cur.next;
    	}
        
    	return dupHead;
    }

	private void link(RandomListNode cur, RandomListNode dup) {
		RandomListNode temp = cur.next;
		cur.next = dup;
		dup.next = temp;
	}
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		RandomListNode o = (RandomListNode)obj;
		
		if (label != o.label)
			return false;
		return true;
	}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("[label = " + label);
		if (next != null) {			
			builder.append(", next.label = " + next.label);
		}
		else {
			builder.append(", next = null");
		}
		if (random != null) {			
			builder.append(", random.label = " + random.label);
		}
		else {
			builder.append(", random = null");
		}
		
		builder.append("]");
		
		return builder.toString();
	}
   
}
