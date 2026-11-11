class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        boolean []visited = new boolean[n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        minHeap.offer(new int[]{0, 0});

        int minCost = 0;
        int connectedPoints = 0;

        while(!minHeap.isEmpty() && connectedPoints < n){
            int []curr = minHeap.poll();

            int cost = curr[0];
            int pointIdx = curr[1];

            if(visited[pointIdx]) continue;

            visited[pointIdx] = true;
            minCost += cost;
            connectedPoints++;

            for(int next = 0; next < n; next++){
                if(visited[next]) continue;

                int distance = Math.abs(points[pointIdx][0] - points[next][0]) + Math.abs(points[pointIdx][1] - points[next][1]);

                minHeap.offer(new int[]{distance, next});
            }
        }

        return minCost;
    }
}
