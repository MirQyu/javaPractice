package niuke;

public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        // write code here
        
        ListNode cur = head, tail = null;
        head = null;
        
        
        while (cur != null) {
            ListNode start = cur;
            int num = 1;
            while (cur.next != null && num < k) {
            	++num;
            	cur = cur.next;
            }
            
            if (num == k) {
                ListNode temp = cur.next;
                cur.next = null;
                cur = temp;
                
                if (tail == null) {
                    head = reverse(start);
                    tail = start;
                }
                else {
                    tail.next = reverse(start);
                    tail = start;
                } 
            }
            else {
            	
                if (tail != null) {
                    tail.next = start;
                }
                else {
                    head = start;
                }
                
                cur = cur.next;
            }
        }
        
        return head;
    }
    
    public ListNode reverse(ListNode head) {
		if (head != null && head.next == null)
            return head;
        ListNode pre = head, cur = pre.next, next;
        
        // 反转后的尾部
        pre.next = null;
        while (cur != null) {
        	next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
}

