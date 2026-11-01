/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> mp = new HashMap<>();

        return clone(node, mp);
    }

    public Node clone(Node node, Map<Node, Node> mp){
        if(mp.containsKey(node)){ // already cloned?
            return mp.get(node);

        }

        Node newNode = new Node(node.val); // create clone
        mp.put(node, newNode);

        for(Node neighbor: node.neighbors){ // iterate over given node neighbors. Clone all neighbors
            Node clonedNeighbor = clone(neighbor, mp);

            newNode.neighbors.add(clonedNeighbor);


        }

        return newNode;
    }
}