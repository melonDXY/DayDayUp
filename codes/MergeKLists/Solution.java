package codes.MergeKLists;

import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
}

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return mergeList(lists, 0, lists.size()-1);
    }
    
    private ListNode mergeList(ArrayList<ListNode> lists, int left, int right) {
        if (left == right) {
            return lists.get(left);
        }
        if(left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        return merge(mergeList(lists, left, mid), mergeList(lists, mid+1, right));
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null){
            return listNode1;
        }
        if( listNode1.val <= listNode2.val) {
            listNode1.next = merge(listNode1.next, listNode2);
            return listNode1;
        }
        else {
            listNode2.next =  merge(listNode1, listNode2.next);
            return listNode2;
        }
    }
    
    private ListNode createList(int start, int end) {
        ListNode head = new ListNode(-1);
        ListNode point = head;
        head.next = point;

        for (int i = start; i <= end; i++) {
            ListNode temp  = new ListNode(i);
            point.next = temp;
            point = point.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> myList = new ArrayList<ListNode>();
        Solution solution = new Solution();
        ListNode list1 = solution.createList(1, 3);
        ListNode list2 = solution.createList(4, 6);
        myList.add(list1);
        myList.add(list2);
        ListNode mlist = solution.mergeKLists(myList);
        while(mlist != null){
            System.out.println(mlist.val);
            mlist = mlist.next;
        }
    }
}