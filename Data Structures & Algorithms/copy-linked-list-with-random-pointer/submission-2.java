/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;

        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;


            curr = curr.next.next;

        }

        curr = head;

        while(curr != null){
            Node newNode = curr.next;

            newNode.random = (curr.random != null) ? curr.random.next: null;
            curr = curr.next.next;

        }

        Node dummyNode = new Node(0);
        Node res = dummyNode;
        curr = head;

        while(curr != null){
            res.next = curr.next;
            curr.next = curr.next.next;

            res = res.next;
            curr = curr.next;

        }


        return dummyNode.next;
        
    }
}
