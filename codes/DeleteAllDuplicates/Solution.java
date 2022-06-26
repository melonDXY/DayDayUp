package codes.DeleteAllDuplicates;


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
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode myHead = pre;
        ListNode start = head;
        ListNode end = head.next;
        boolean haveDuplicate = false;
        while (end != null){
            if (start.val == end.val){
                haveDuplicate = true;
                end = end.next;
                continue;
            }
            if (haveDuplicate){
                pre.next = end;
                start = end;
                end = end.next;
                haveDuplicate = false;
                continue;
            }
            pre = pre.next;
            start = start.next;
            end = end.next;

        }
        if(haveDuplicate){
            pre.next = end;
        }
        return myHead.next;
    }
}