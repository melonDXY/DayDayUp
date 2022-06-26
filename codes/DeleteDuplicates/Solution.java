package codes.DeleteDuplicates;

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
    public ListNode(int val) {
      this.val = val;
    }
}

public class Solution {
    /**
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        
        while (cur != null){
            if (pre.val == cur.val){
                pre.next = cur.next;
            }
            else{
                pre = pre.next;
            }
            cur = cur.next;

        }

        return head;
    }
}