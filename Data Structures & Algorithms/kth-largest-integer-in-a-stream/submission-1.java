class KthLargest {
    //take s.c as O(k)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    int K = 0;

    public KthLargest(int k, int[] nums) { // takes O(n * logk)

        K = k;

        for(int x: nums){
            minHeap.offer(x);

            if(minHeap.size() > K) minHeap.poll();

        }

    }
    
    public int add(int val) { // takes O(m * logk)
        minHeap.offer(val);

        if(minHeap.size() > K) minHeap.poll();

        return minHeap.peek();
        
    }
}
