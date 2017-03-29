package niuke;

import java.util.Stack;

public class TwoStack {
	Stack<Integer> stackPush = new Stack<>();
	Stack<Integer> stackPop = new Stack<>();
	public int[] twoStack(int[] ope, int n) {
        // write code here
        TwoStack queue = new TwoStack();
        int num = 0;
        for (int i = 0; i < n; i++)
        	if (ope[i] == 0)
        		num++;
        int[] ans = new int[num];
        int index = 0;
        for (int i = 0; i < n; ++i) {
        	if (ope[i] == 0) {
        		ans[index++] = queue.pop();
        	}
        	else {
        		queue.push(ope[i]);
        	}
        }
        
        return ans;
    }
	
	public void push(int node) {
		stackPush.push(node);
	}
	
	public int pop() {
		
		if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		
		return stackPop.pop();
	}
}
