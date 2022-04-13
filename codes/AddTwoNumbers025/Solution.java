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

    public ListNode addInList2 (ListNode head1, ListNode head2) {
        // write code here
        ListNode list1 = reverse(head1);
        ListNode list2 = reverse(head2);
        int temp10 = 0;
        ListNode myhead = new ListNode();

        while(list1 != null || list2 != null || temp10 != 0) {
            int x = list1 == null? 0: list1.val;
            int y = list2 == null? 0: list2.val;
            
            ListNode tempNode = new ListNode();
            int total = x + y + temp10;
            temp10 = total / 10;
            int num = total % 10;
            tempNode.val = num;
            tempNode.next = myhead.next;
            myhead.next  = tempNode;
            list1 = list1 == null?  null : list1.next;
            list2 = list2 == null?  null : list2.next;;
        }

        return myhead.next;
        // if ( list1 == null ) {
        //     if (list2 == null && temp10 != 0) {
        //         ListNode tempListNode = new ListNode();
        //         tempListNode.val = temp10;
        //         tempListNode.next = myhead.next;
        //         myhead.next = tempListNode;
        //         return myhead.next;
        //     }
        //     else {
        //         if (temp10 == 0) {
        //             while(list2 != null){
        //                 ListNode t = list2.next;
        //                 list2.next = myhead.next;
        //                 myhead.next = list2;
        //                 list2 = t;
        //             }
        //             return myhead.next;
        //         }
        //         else {
        //             int total = temp10 + list2.val;
        //             if(total/10 == 0){
        //                 list2.val = total;
        //                 while(list2 != null){
        //                     ListNode t = list2.next;
        //                     list2.next = myhead.next;
        //                     myhead.next = list2;
        //                     list2 = t;
        //                 }
        //             }else{}
        //         }
        //     }
        // }
    }

    public ListNode reverse(ListNode head) {
        ListNode myHead = null;

        while(head != null){
            ListNode temp = head.next;
            head.next = myHead;
            myHead = head;
            head = temp;
        }
        return myHead;

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

    public static ListNode createList(int num) {
        ListNode head = new ListNode();
            while(num % 10 != 0) {
                ListNode temp = new ListNode();
                temp.val = num % 10;
                System.out.println(num%10);
                num/=10;
                temp.next = head.next;
                head.next = temp;
            }
            return head.next;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode head1 = Solution.createList(937);
        ListNode head2 = Solution.createList(63);
        
        
        ListNode head = new ListNode();
        head = solution.addInList2(head1, head2);
        // while(num % 10 != 0) {
        //     ListNode temp = new ListNode();
        //     temp.val = num % 10;
        //     System.out.println(num%10);
        //     num/=10;
        //     temp.next = head.next;
        //     head.next = temp;
        // }
        // head = head.next;
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

