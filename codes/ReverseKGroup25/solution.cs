/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ReverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummyhead = new ListNode(0, head);
        ListNode insertPos = dummyhead;
        ListNode curNode = dummyhead.next;
        while(curNode != null){
            while(curNode != null && stack.Count < k){
                stack.Push(curNode);
                curNode = curNode.next;
            }
            if(curNode == null && stack.Count != k)
            {
                while(stack.Count > 1){
                    stack.Pop();
                }
                insertPos.next = stack.Pop();
            }
            else
            {
                while(stack.Count > 0){
                    insertPos.next = stack.Pop();
                    insertPos = insertPos.next;
                    insertPos.next = null;
                }
            }
        }
        return dummyhead.next;
    }
}