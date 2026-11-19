class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // approach: multi-source BFS
        if(grid == null || grid.length == 0 || grid[0].length == 0) return;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<grid.length; i++){
            for(int j=0; j < grid[0].length; j++){

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
            int []curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for(int []dir: directions){
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if(nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length){
                    continue;

                }

                if(grid[nextRow][nextCol] != Integer.MAX_VALUE) continue;

                grid[nextRow][nextCol] = grid[row][col] + 1;

                q.offer(new int[]{nextRow, nextCol});
            }
        }


    }
}
