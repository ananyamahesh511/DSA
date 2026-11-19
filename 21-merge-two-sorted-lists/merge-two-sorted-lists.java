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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;

        ListNode l = list1;
        ListNode r = list2;

        while(l != null && r != null){
            if(l.val <= r.val){
                d.next = l;
                l = l.next;
            }else{
                d.next = r;
                r = r.next;
            }
            d = d.next;
        }

        while(l != null){
            d.next = l;
            l = l.next;
            d = d.next;
        }

        while(r != null){
            d.next = r;
            r = r.next;
            d = d.next;
        }

        return dummy.next;
    }
}