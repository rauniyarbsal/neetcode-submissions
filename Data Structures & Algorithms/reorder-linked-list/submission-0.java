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
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode l1 = head;
        ListNode l2 = reverseLL(slow.next);
        slow.next = null;



        mergeTwoLL(l1 , l2);
        
    }

    public static ListNode reverseLL(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }

        return prev;
    }

    public static void mergeTwoLL(ListNode l1, ListNode l2){
        ListNode curr = l1, temp = l2;

        while(l1 != null && l2 != null){
            curr = l1.next;
            l1.next = l2;
            l1 = curr;
            temp = l2.next;
            l2.next = l1;
            l2 = temp;

        }

        

    }
}
