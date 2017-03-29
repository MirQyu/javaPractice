package niuke;

import java.util.Stack;

public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        // write code here
        // record index
        int[] leftMaxTable = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    stack.pop();
           	}
            
            if (stack.isEmpty()) {
                leftMaxTable[i] = -1;
            }
            else {
                leftMaxTable[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        stack.clear();
        
        int[] rightMaxTable = new int[n];
        for (int i = n-1; i > -1; i--) {
        	while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    stack.pop();
           	}
            
            if (stack.isEmpty()) {
                rightMaxTable[i] = -1;
            }
            else {
                rightMaxTable[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (leftMaxTable[i] != -1) {
                if (rightMaxTable[i] != -1) {
                    ans[i] = (A[leftMaxTable[i]] < A[rightMaxTable[i]]) 
                        ? leftMaxTable[i] : rightMaxTable[i];
                }
                else {	// rig == -1
            		ans[i] = leftMaxTable[i];
                }
            }
            else {
                ans[i] = rightMaxTable[i];
            }
        }
        
        return ans;
    }
}