package niuke;

import java.util.Stack;
/**
 * 	!!!!重要
 * 	实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 *
 *	给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。	
 *	测试样例：
 *	[4,3,2,1],4
 *	返回：[1,2,3,4]
 * @author MirQ
 *
 */
public class StackReverse {
	
	int[] stack;
	public int[] reverseStack(int[] A, int n) {
        // write code here
        stack = A;
        reverse(n);
        return A;
    }
	
	public void reverse(int size) {
		if (size > 0) {
			int i = getFirst(--size);
			reverse(size);
			stack[size] = i;
		}
	}
	
	/**
	 * @param topIndex 一直都是当前栈顶
	 * @return
	 */
	public int getFirst(int topIndex) {
		int result = stack[topIndex--];
		if (topIndex == -1) {
			return result;
		}
		else {
			int last = getFirst(topIndex);
			stack[topIndex] = result;
			return last;
		}
	}
}
