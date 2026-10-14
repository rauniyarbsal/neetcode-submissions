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
    public void reorderList(ListNode head) {
        // find middle node
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode l1 = head;
        ListNode l2 = reverseLL(slow.next);
        slow.next = null;

        mergeLL(l1, l2);
        
    }


    public ListNode reverseLL(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

        }

        return prev;
    }

    public void mergeLL(ListNode l1, ListNode l2){
        ListNode curr = l1, temp = l2;

        while(l1 != null && l2 != null){
            curr = curr.next;
            l1.next = l2;
            l1 = curr;

            temp = temp.next;
            l2.next = l1;
            l2 = temp;
        }
    }
}
