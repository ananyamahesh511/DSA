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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        int size = 0;
        ListNode cur = head;

        while(cur != null){
            size++;
            cur = cur.next;
        }

        if(n == size){
            head = head.next;
            return head;
        }

        int i = 0;
        ListNode prev = head;
        while(prev != null){
            i++;
            if(i == size - n){
                break;
            }
            prev = prev.next;
        }

        ListNode node = prev.next;

        if(node.next != null){
            prev.next = node.next;
        }else{
            prev.next = null;
        }

        return head;
    }
}