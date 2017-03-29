package niuke;

public class Divide {
	public ListNode listDivide(ListNode head, int val) {
		ListNode h1 = null, t1 = null;
		ListNode h2 = null, t2 = null;
		
		ListNode current = head;
		while (current != null) {
			if (current.val < val) {
				if (null == t1) {
					h1 = t1 = current;
				}
				else {
					t1.next = current;
					t1 = current;
				}
			}
			else {
				if (null == t2) {					
					h2 = t2 = current;
				}
				else {
					t2.next = current;
					t2 = current;
				}
			}
			
			current = current.next;
		}
		
		t2.next = null;
		t1.next = h2;
		
		return h1;
	}
}
