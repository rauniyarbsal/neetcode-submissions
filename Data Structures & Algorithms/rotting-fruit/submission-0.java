class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int minute = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Find all initial rotten fruits
        // and count fresh fruits
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == 2) {
                    q.offer(new int[]{row, col});
                }

                if (grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        // Multi-source BFS
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();
            minute++;

            // Process exactly one BFS level/minute
            for (int i = 0; i < size; i++) {

                int[] rotten = q.poll();

                for (int[] dir : directions) {

                    int newRow = rotten[0] + dir[0];
                    int newCol = rotten[1] + dir[1];

                    if (newRow < 0 ||
                        newCol < 0 ||
                        newRow >= grid.length ||
                        newCol >= grid[0].length) {
                        continue;
                    }

                    // Only fresh fruit can become rotten
                    if (grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return fresh == 0 ? minute : -1;
    }
}