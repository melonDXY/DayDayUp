package codes.OddEvenList;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
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
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        // write code here
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        boolean isOdd = true;
        ListNode pre = head;
        ListNode cur = head.next;
        
        ListNode point1 = pre;
        ListNode point2 = cur;

        head = head.next.next;
        while (head != null) {
            if(isOdd){
                point1.next = head;
                head = head.next;
                point1 = point1.next;
                isOdd = false;
            }
            else{
                point2.next = head;
                head = head.next;
                point2 = point2.next;
                isOdd = true;
            }
        }
        
        point1.next = cur;
        point2.next = null;
        return pre;

    }
}