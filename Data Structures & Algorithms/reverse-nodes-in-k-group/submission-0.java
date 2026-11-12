class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // 1. Find kth node
            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Fewer than k nodes remain
            if (kth == null) {
                break;
            }

            // 2. Save boundaries
            ListNode groupNext = kth.next;
            ListNode groupHead = groupPrev.next;

            // 3. Reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupHead;

            while (curr != groupNext) {

                ListNode next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            // 4. Connect previous part to new group head
            groupPrev.next = prev;

            // 5. Old head became tail
            //    and is now before the next group
            groupPrev = groupHead;
        }

        return dummy.next;
    }
}