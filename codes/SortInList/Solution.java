package codes.SortInList;

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
}

public class Solution {
    /**
     * 
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    ListNode merge (ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;


        while (head1 != null && head2 != null) {
            if( head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        if (head1 == null) {
            cur.next = head2;
        } else {
            cur.next = head1;
        }

        return dummyHead.next;
    }
    public ListNode sortInList (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;

        while(right != null) {
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        left.next = null;

        return merge(sortInList(head), sortInList(mid));

    }
}