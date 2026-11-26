class MedianFinder {
    PriorityQueue<Integer> small; // small-maxHeap contains ele < large-minHeap
    PriorityQueue<Integer> large; // large-minHeap contains ele > small-maxHeap

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();

    }
    
    public void addNum(int num) {
        // 1. validate if small Heap maintaing Max at top is empty or new num <= smallMaxHeap.peek(), insert
        if(small.isEmpty() || num <= small.peek()){
            small.offer(num);

        }else{
            large.offer(num);

        }

        // 2. Rebalance heap if one gets larger than other and Two heap should be |small-maxHeap - large-maxHeap| <= 1
        if(small.size() > large.size() + 1){
            large.offer(small.poll());

        }
        
        if(large.size() > small.size() + 1){

            small.offer(large.poll());
        }
        
    }
    
    public double findMedian() {
        
        //1. if both heap are balanced, even len
        if(small.size() == large.size()){
            return ((small.peek() + large.peek()) / 2.0);

        }else{
            //2. odd len
            if(small.size() > large.size()) return small.peek();
            else return large.peek();

        }
    }
}
