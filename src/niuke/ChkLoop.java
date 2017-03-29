package niuke;

public class ChkLoop {
	public int chkLoop(ListNode head, int adjust) {
        // write code here
        
        ListNode p1 = head, p2 = head;
        boolean hasRing = false;
        
        while (p2 != null && p2.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        	
        	if (p1 == p2) {
        		hasRing = true;
        		break;
        	}
        }
        
        if (!hasRing)
        	return -1;
        
        p2 = head;
        
        while (p2 != p1) {
        	p2 = p2.next;
        	p1 = p1.next;
        }
        
        return p2.val;
    }
	
	public ListNode getFirstNodeOfRing(ListNode head) {
        ListNode p1 = head, p2 = head;
        boolean hasRing = false;
        
        while (p2 != null && p2.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        	
        	if (p1 == p2) {
        		hasRing = true;
        		break;
        	}
        }
        
        if (!hasRing)
        	return null;
        
        p2 = head;
        
        while (p2 != p1) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        
        return p1;
        
    }
}

