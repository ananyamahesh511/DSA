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
    ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode next;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode mid = findMid(head);

        ListNode next = mid.next;
        mid.next = null;

        ListNode revHead = reverse(next);

        ListNode t1 = head;
        ListNode t2 = revHead;

        while(t1 != null && t2 != null){
            if(t1.val != t2.val) return false;
            t1 = t1.next;
            t2 = t2.next;
        }

        return true;
    }
}