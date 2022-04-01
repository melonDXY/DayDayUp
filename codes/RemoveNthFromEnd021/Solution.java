package codes.RemoveNthFromEnd021;

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
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if (head == null || n == 0) return head;
        ListNode startPoint = new ListNode(-1);
        startPoint.next = head;
        ListNode endPoint = head;
        
        for (int i = 0; i < n; i++) {
            endPoint = endPoint.next;
        }
        
        if (endPoint == null) return head.next;
        
        
        
        while (endPoint != null){
            endPoint = endPoint.next;
            startPoint = startPoint.next;
        }
        startPoint.next = startPoint.next.next;
        return head;
    }
    
    
}