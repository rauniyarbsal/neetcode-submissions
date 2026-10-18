class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int x: stones) pq.offer(x);

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if(x == y){
                continue;

            }

            if(x > y){
                pq.offer(x - y);

            }

            if(x < y){
                pq.offer(y - x);

            }

        }
        
        return (pq.size() == 1) ? pq.poll() : 0;
    }
}
