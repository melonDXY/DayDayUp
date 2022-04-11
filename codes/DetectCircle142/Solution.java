package codes.DetectCircle142;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
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
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while(head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }
            nodeSet.add(head);
            head = head.next;
        }
        return null;
    }
}