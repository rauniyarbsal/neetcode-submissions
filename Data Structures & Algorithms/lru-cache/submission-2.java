class LRUCache {

    static class Node{
        int key;
        int value;
        Node next = null;
        Node prev = null;

        Node(int key, int value){
            this.key = key;
            this.value = value;

        }

    }

    Map<Integer, Node> cache;
    int capacity;

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    public void insert(Node newNode){
        Node curr = head.next;
        newNode.next = curr;
        curr.prev = newNode;

        head.next = newNode;
        newNode.prev = head;
    }

    public void delete(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }
    
    public int get(int key) {

        if(cache.containsKey(key)){
            Node ans = cache.get(key);
            delete(ans);
            insert(ans);

            return ans.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node existingNode = cache.get(key);
            existingNode.value = value;

            delete(existingNode);
            insert(existingNode);
            return;


        }

        if(cache.size() == capacity){
            cache.remove(tail.prev.key);
            delete(tail.prev); // delete LRU node which is sitting infront of tail.prev
        }

        Node newNode = new Node(key, value);
        insert(newNode);
        
        cache.put(key, newNode);


    }
}
