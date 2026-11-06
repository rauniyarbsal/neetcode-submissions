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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        int interval = 1;

        while(interval < lists.length){

            for(int i=0; i + interval < lists.length; i += 2 * interval){
                lists[i] = mergeTwoList(lists[i], lists[i + interval]);

            }

            interval *= 2;
        }
        
        return lists[0];
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode;

        while(list1 != null && list2 != null){

            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;

            }else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;

            }

        }

        if(list1 != null) temp.next = list1;

        if(list2 != null) temp.next = list2;

        return dummyNode.next;
    }
}
