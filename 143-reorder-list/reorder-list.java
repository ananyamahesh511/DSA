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
    ListNode util(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public void reorderList(ListNode head) {
        ListNode midnode = util(head);

        Stack<ListNode> st = new Stack<>();
        ListNode cur = midnode.next;
        midnode.next = null;

        while(cur != null){
            st.push(cur);
            cur = cur.next;
        }

        ListNode ptr = head;

        while(ptr != null && ptr.next != null && st.size() > 0){
            ListNode node = st.pop();

            ListNode nextPtr = ptr.next; 
            ptr.next = node;             
            node.next = nextPtr;  


            ptr = nextPtr;
        }

    }
}