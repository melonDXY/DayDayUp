package codes.ReverseKGroup25;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode dummy = new ListNode(-1);
        ListNode pre;
        ListNode end;
        ListNode left;
        ListNode right;
        
        
        dummy.next = head;
        end = dummy;
        //left = dummy.next;
        pre = dummy;
        
        while(end != null){
            
            for(int i=0; i < k && end != null; i++) {
                end = end.next;
            }
            
            if(end == null) 
                break;
            
            right = end.next;
            left = pre.next;
            end.next = null;
            
            pre.next = reverse(left);
            left.next = right;
            pre = left;
            //left = left.next;
            end = pre;
        }
        return dummy.next;
        
        
    }
    
    private ListNode reverse (ListNode head) {
        ListNode newHead = new ListNode(-1);
        
        while(head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        
        return newHead;
    }
}
