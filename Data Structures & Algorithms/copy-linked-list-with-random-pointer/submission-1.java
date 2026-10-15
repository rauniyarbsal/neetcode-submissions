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
        Map<Node, Node> mp = new HashMap<>();

        Node temp = head;

        while(temp != null){ // first copy node from original and store original and copy node to map
            Node temp1 = new Node(temp.val);

            mp.put(temp, temp1);

            temp = temp.next;
            temp1 = temp1.next;


        }


        temp = head;

        while(temp != null){ // build next and random based on map reference
            Node temp1= mp.get(temp);
            temp1.next = mp.get(temp.next);
            temp1.random = mp.get(temp.random);

            temp = temp.next;
            temp1 = temp1.next;

        }


        return mp.get(head);
        
    }
}
