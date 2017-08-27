package easy.done;

public class AddTwoNumbers2 {
    
//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
     
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode root = null;
            ListNode tail = null;
            
            while(l1 != null || l2 != null || carry != 0) {
                if(root == null) {
                    root = new ListNode(0);
                    tail = root;
                } else {
                    tail.next = new ListNode(0);
                    tail = tail.next;
                }
                
                int val1 = l1 == null? 0 : l1.val;
                int val2 = l2 == null? 0 : l2.val;
                int sum = val1 + val2 + carry;
                int temp = sum % 10;
                carry = sum / 10;
                
                tail.val = temp;
                
                l1 = l1 == null? l1 : l1.next;
                l2 = l2 == null? l2 : l2.next;
            }
            
            return root;
        }
    }
}
