package codes.AddTwoNumbers025;


class ListNode {
   int val;
   ListNode next = null;
 }
 

public class Solution {
    /**
     * 
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */

    //超时啦！
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        int num1 = this.listToInteger(head1);
        int num2 = this.listToInteger(head2);
        int num = 0;
        int val = 0;
        ListNode head = new ListNode();
        ListNode tail = null;
        head.next = tail;
        
        num = num1 + num2;
        
        while(num % 10 != 0) {
            val = num % 10;
            ListNode temp = new ListNode();
            temp.val = val;
            temp.next = tail;
            tail = temp;
            head.next = tail;
        }
        return head.next;
        
    }
    
    private int listToInteger(ListNode head) {
        StringBuilder num = new StringBuilder();
        ListNode point = head;
        
        while(point != null){
            num.append(point.val);
            point = point.next;
        }
        
        String str = num.toString();
        return Integer.parseInt(str);
    }



    public static void main(String[] args) {
        int num = 1234;
        ListNode head = new ListNode();
        while(num % 10 != 0) {
            ListNode temp = new ListNode();
            temp.val = num % 10;
            System.out.println(num%10);
            num/=10;
            temp.next = head.next;
            head.next = temp;
        }
        head = head.next;
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}