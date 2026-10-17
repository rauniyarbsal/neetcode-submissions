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
        while(temp != null){
            Node newNode = new Node(temp.val);
            mp.put(temp, newNode);

            newNode = newNode.next;
            temp = temp.next;

        }

        temp = head;
        while(temp != null){
            Node newNode = mp.get(temp);
            newNode.next = mp.get(temp.next);

            newNode = newNode.next;
            temp = temp.next;

        }

        temp = head;
        while(temp != null){
            Node newNode = mp.get(temp);
            newNode.random = mp.get(temp.random);

            newNode = newNode.next;
            temp = temp.next;

        }


        return mp.get(head);
        
    }
}
