package niuke;

public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode n1 = getFirstNodeOfRing(head1), n2 = getFirstNodeOfRing(head2);
        // 两种情况， 有环， 无环
        if (n1 == n2) {
            return true;
        }
        
        if (n1 != null && n2 != null) {
            ListNode tmp = n1.next;
            while (tmp != n1) {
                if (tmp == n2) {
                    return true;
                }
                tmp = tmp.next;
            }
        }
        
        if (null == n1 && null == n2) {
           	int sizeA = getSize(head1), sizeB = getSize(head2);
            n1 = head1;
            n2 = head2;
            while (sizeA > sizeB) {
				sizeA--;
                n1 = n1.next;
            }
            
            while (sizeB > sizeA) {
                sizeB--;
                n2 = n2.next;
            }
            
            while (n1 != null) {
                if (n1 == n2) {
                    return true;
                }
                
                n1 = n1.next;
                n2 = n2.next;
            }
        }
        
        return false;
    }
    
    public int getSize(ListNode head) {
        int size = 0;
        
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        
        return size;
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
