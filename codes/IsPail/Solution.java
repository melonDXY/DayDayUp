package codes.IsPail;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */
class ListNode {
     int val;
     ListNode next = null;

     ListNode(int val){
         this.val = val;
     }
}

public class Solution {
    /**
     * 
     * @param head ListNode类 the head
     * @return bool布尔型
     */

    ListNode reverse(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummyHead;
            dummyHead = head;
            head = temp;
        }
        return dummyHead;
    }
    
    public boolean isPail (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return true;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;
        while(right != null && right.next != null){
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }

        left.next = null;

        mid = reverse(mid);

        while (head != null && mid != null) {
            if (head.val != mid.val)
                return false;
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
}