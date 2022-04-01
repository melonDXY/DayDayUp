package codes.GetIntersectionNode52;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode point1 = pHead1;
        ListNode point2 = pHead2;
        
        while(point1 != point2) {
            point1 = point1 == null? pHead2 : point1.next;
            point2 = point2 == null? pHead1 : point2.next;
        }
        return point1;
    }
}