class Solution {
    // Optimal multi-source BFS solution
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n) in the worst case

    public void islandsAndTreasure(int[][] grid) {
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) return;

        int rows = grid.length;
        int cols = grid[0].length;

        // Each int[] will hold {row, column}
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});

                }
            }
        }

        int [][]directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while(!q.isEmpty()){
            int []current = q.poll();

            int row = current[0];
            int col = current[1];

            for(int []direction: directions){
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                if(nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols){
                    continue;

                } 

                if(grid[nextRow][nextCol] != Integer.MAX_VALUE) continue;

                grid[nextRow][nextCol] = grid[row][col] + 1;

                q.offer(new int[]{nextRow, nextCol});
            }

        }
    }
}
