class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
            1. Build weighted adjacency list:
            source → (destination, weight)
        */
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int []time: times){
            int src = time[0];
            int dest = time[1];
            int weight = time[2];

            adj.computeIfAbsent(src, key -> new ArrayList<>())
            .add(new int[]{dest, weight});

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, k}); // starting point

        Set<Integer> visited = new HashSet<>(); // to keep track whether all
        // nodes are visited or not

        int maxTime = 0;

        while(!pq.isEmpty()){
            int []curr = pq.poll();

            int currTime = curr[0];
            int currNode = curr[1];

            if(visited.contains(currNode)) continue;

            visited.add(currNode);

            maxTime = currTime;

            for (int[] neighbour : adj.getOrDefault(currNode, 
            new ArrayList<>())) {
                int dest = neighbour[0];
                int edgeWeight = neighbour[1];

                int newTime = currTime + edgeWeight;

                pq.offer(new int[]{newTime, dest});
            }

        }

        
        
        return (visited.size() == n) ? maxTime: -1;
    }
}
