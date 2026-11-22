class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int []time: times){
            int src = time[0];
            int dest = time[1];
            int dist = time[2];

            adjList.computeIfAbsent(src, key->new ArrayList()).add(new int[]{dest, dist});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b)-> Integer.compare(a[0], b[0])

        );

        int maxTime = 0;

        minHeap.offer(new int[]{0, k}); // start time and point

        Set<Integer> visited = new HashSet<>();

        while(!minHeap.isEmpty()){
            int []curr = minHeap.poll();

            int currTime = curr[0];
            int currNode = curr[1];

            if(visited.contains(currNode)) continue;

            visited.add(currNode);

            maxTime = currTime;

            for(int []neighbor: adjList.getOrDefault(currNode, new ArrayList<>())){
                int node = neighbor[0];
                int nodeWeight = neighbor[1];

                minHeap.offer(new int[]{maxTime + nodeWeight, node});
            }


        }

        return (visited.size() == n) ? maxTime: -1;
    }
}
