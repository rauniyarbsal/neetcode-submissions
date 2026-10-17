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

        Node temp = head;


        while(temp != null){ // insert inbetween each node
            Node curr = new Node(temp.val);
            curr.next = temp.next;
            temp.next = curr;

           temp = temp.next.next;

        }

        temp = head;

        while(temp != null){
            Node curr = temp.next;
            curr.random = (temp.random == null) ? null : temp.random.next;

            temp = temp.next.next;
        }

        Node dummyNode = new Node(0);
        Node res = dummyNode;
        temp = head;

        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
