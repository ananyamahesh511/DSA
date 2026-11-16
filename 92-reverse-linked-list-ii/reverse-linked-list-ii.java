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
    ListNode util(ListNode head, ListNode start, ListNode next){
        ListNode cur = start;
        ListNode prev = null;
        ListNode nextt;

        while(cur != next){
            nextt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextt; 
        }

        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 0;
        ListNode cur = head;

        ListNode prev = null;

        while(cur != null){
            i++;
            if(i == left) break;
            prev = cur;
            cur = cur.next;
        }

        ListNode start = cur;

        i = 0;
        cur = head;
        while(cur != null){
            i++;
            if(i == right) break;
            cur = cur.next;
        }
        ListNode next = cur.next;

        ListNode reverseHead = util(head, start, next);
        if(prev != null) prev.next = reverseHead;
        else if(prev == null) head = reverseHead;
        
        if(next != null) start.next = next;

        return head; 
    }
}