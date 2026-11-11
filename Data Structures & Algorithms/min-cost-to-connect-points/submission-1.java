class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        // Tracks which points are already part of MST
        boolean[] visited = new boolean[n];

        // {cost, pointIndex}
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Start from point 0 with cost 0
        minHeap.offer(new int[]{0, 0});

        int minCost = 0;
        int connectedPoints = 0;

        while (!minHeap.isEmpty() && connectedPoints < n) {

            // Get cheapest candidate connection
            int[] curr = minHeap.poll();

            int cost = curr[0];
            int pointIdx = curr[1];

            // Point already included in MST
            if (visited[pointIdx]) {
                continue;
            }

            // Add this point to MST
            visited[pointIdx] = true;
            minCost += cost;
            connectedPoints++;

            // Explore connections to every unvisited point
            for (int next = 0; next < n; next++) {

                if (visited[next]) {
                    continue;
                }

                // Manhattan distance
                int distance =
                    Math.abs(points[pointIdx][0] - points[next][0])
                    +
                    Math.abs(points[pointIdx][1] - points[next][1]);

                // Candidate connection
                minHeap.offer(new int[]{distance, next});
            }
        }

        return minCost;
    }
}