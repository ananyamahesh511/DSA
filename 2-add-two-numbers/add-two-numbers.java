/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode l = l1;
        ListNode r = l2;

        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;

        while(l != null && r != null){
            int sum = l.val + r.val + carry;

            if(sum < 10){
                d.next = new ListNode(sum);
                carry = 0;
                
                d = d.next;
            }else{
                int ld = sum % 10;
                d.next = new ListNode(ld);
                carry = 1;

                d = d.next;
            }

            l = l.next;
            r = r.next;
        }

        while(l != null){
            int sum = l.val + carry;
            
            if(sum < 10){
                d.next = new ListNode(sum);
                carry = 0;
                d = d.next;
            }else{
                int ld = sum % 10;
                d.next = new ListNode(ld);
                carry = 1;

                d = d.next;
            }
            
            l = l.next;
        }

        while(r != null){
            int sum = r.val + carry;
            
            if(sum < 10){
                d.next = new ListNode(sum);
                carry = 0;
                d = d.next;
            }else{
                int ld = sum % 10;
                d.next = new ListNode(ld);
                carry = 1;

                d = d.next;
            }
            
            r = r.next;
        }

        if(carry == 1){
            d.next = new ListNode(1);
        }

        return dummy.next;
    }
}