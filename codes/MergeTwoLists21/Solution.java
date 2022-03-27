package codes.MergeTwoLists21;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode point1 = list1;
        ListNode point2 = list2;
        ListNode mergeList = new ListNode(-1);
        ListNode mPoint = mergeList;
        mergeList.next = mPoint;
        mPoint = list1.val < list2.val ? list1 : list2;

        while(point1 != null && point2 != null) {
            if (point1.val <= point2.val) {
                //ListNode temp = point1.next;
                mPoint.next = point1;
                point1 = point1.next;
                mPoint = mPoint.next;
            }
            else {
                mPoint.next = point2;
                point2 = point2.next;
                mPoint = mPoint.next;
            }
        }
        if (point1 == null) {
            mPoint.next = point2;
        }
        else if (point2 == null) {
            mPoint.next = point1;
        }
        return mergeList.next;

    }

    //递归判断，返回(要慢一点)
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = Merge2(list1.next, list2);
            return list1;
        }
        else {
            list2.next = Merge2(list1, list2.next);
            return list2;
        }
    }
}