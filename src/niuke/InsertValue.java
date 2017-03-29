package niuke;

public class InsertValue {
	
	public static void main(String[] args) {
		InsertValue iv = new InsertValue();
		int[] A = {7,5,4,3,2,1};
		int[] nxt = {5,0,1,2,3,4};
		
		ListNode node = iv.insert(A, nxt, 2);
		ListNode next = node;
		
		for (int i = 0; i < A.length + 1; i++) {
			System.out.print(next.val + " ");
			next = next.next;
		}
	}
	
	public ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
		if (A == null || A.length == 0) {
            return new ListNode(val);
        }
		
		ListNode insertNode = new ListNode(val);
		
		int headIndex = 0;
		for (int i = 1; i < A.length; ++i) {
			headIndex = (A[i] < A[headIndex])
					? i : headIndex;
		}
		//System.out.println("最小值为：" + A[headIndex]);
	
		ListNode pre = new ListNode(A[headIndex]), cur = null;
		// head node
		ListNode node = pre;
		
		int preIndex = headIndex;
		
		for (int i = 0; i < A.length; i++) {	
			
			int curIndex = nxt[preIndex];
			//System.out.println("当前值为：" + A[curIndex]);
			if (curIndex != headIndex) {
				cur = new ListNode(A[curIndex]);
				if (insertNode != null && pre.val <= insertNode.val 
									   && cur.val >= insertNode.val) {
					pre.next = insertNode;
					insertNode.next = cur;
					insertNode = null;
				}
				else {
					pre.next = cur;
				}
				pre = cur;
				preIndex = curIndex;
				
			}
			else {
				cur = node;
//				if (insertNode != null) {
//					pre.next = insertNode;
//					insertNode.next = cur;
//					if (insertNode.val < node.val) {
//						node = insertNode;
//					}
//				}
//				pre.next = cur;
				
				if (insertNode != null) {
					if (insertNode.val < node.val) {
                        insertNode.next = cur;
						node = insertNode;
					}
                    else {
                        pre.next = insertNode;
                    }
				}
			}
		}
		
		return node;
    }
}

class ListNode {
	int val;
	ListNode next = null;
	
	public ListNode(int val) {
		this.val = val;
	}
}
