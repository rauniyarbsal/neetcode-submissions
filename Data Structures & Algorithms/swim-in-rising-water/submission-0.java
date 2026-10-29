class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;

        //[requiredTime, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a[0], b[0])
        );

        boolean [][]visited = new boolean[grid.length][grid[0].length];

        //starting cell
        pq.offer(new int[]{grid[0][0], 0, 0});

        int [][]directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!pq.isEmpty()){
            int []curr = pq.poll();

            int currTime = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(visited[row][col]) continue;

            visited[row][col] = true;

            // Reached destination
            if(row == n - 1 && col == n - 1) return currTime;

            // Explore neighbors
            for(int []dir: directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= n){
                    continue;

                }

                if(visited[newRow][newCol]) continue;

                int newTime = Math.max(currTime, grid[newRow][newCol]);

                pq.offer(new int[]{newTime, newRow, newCol});
            }
        }

        return -1;
    }
}
