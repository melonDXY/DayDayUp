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
     * @param m int整型 
     * @param n int整型 
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        //前一个
        ListNode pre;
        //反转开始
        ListNode left;
        //反转结束
        ListNode right;
        //后一个
        ListNode cur;

        ListNode point = new ListNode(-1);
        point.next = head;
        pre = point;
        for(int i = 0; i<m-1; i++) {
            pre = pre.next;
        }
        
        left = pre.next;
        right = left;

        for(int i = 0; i < n-m; i++) {
            right = right.next;
        }
        
        cur = right.next;

        //切断（头部以前也要切）
        pre.next = null;
        right.next = null;

        ListNode result = reverse(left);

        pre.next = result;
        left.next = cur;

        return point.next;
    }

    private ListNode reverse(ListNode head){
        ListNode newHead = null;
       // newHead[1] = head;
        while(head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }
}