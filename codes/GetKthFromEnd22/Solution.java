package codes.GetKthFromEnd22;


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
     * 
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode point = null;
        if (pHead == null || k == 0) return point;
        point = pHead;
        int window = 1;
        while(point != null) {
            while (window < k && point != null) {
                point = point.next;
                window++;
            }
            if (point == null) return point;
            if (point.next == null) return pHead;
            point = point.next;
            pHead = pHead.next;
        }
        return pHead;
    }
}