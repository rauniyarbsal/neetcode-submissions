class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int K = 0;

    public KthLargest(int k, int[] nums) {
        K = k;

        for(int x: nums){
            minHeap.offer(x);

            if(minHeap.size() > k) minHeap.poll();
        }
        
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > K) minHeap.poll();
        
        return minHeap.peek();
    }
}
