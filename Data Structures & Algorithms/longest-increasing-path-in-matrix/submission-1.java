class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int [][]dp = new int[matrix.length][matrix[0].length];

        int longestPath = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int findLongest = dfs(matrix, i, j, dp);

                longestPath = Math.max(longestPath, findLongest);
            }
        }

        return longestPath;
    }

    public int dfs(int[][] matrix, int row, int col, int [][]dp) {
        if(dp[row][col] != 0) return dp[row][col];

        int currBest = 1;

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // 1. Check bounds
            if (newRow < 0 || newCol < 0 || newRow >= matrix.length || newCol >= matrix[0].length) {
                continue;
            }

            // 2. Must be strictly increasing
            if (matrix[newRow][newCol] <= matrix[row][col]) {
                continue;
            }

            // 3. Explore valid neighbor
            int nextPath = dfs(matrix, newRow, newCol, dp);

            // 4. Keep longest path
            currBest = Math.max(currBest, 1 + nextPath);
        }

         dp[row][col] = currBest;
         
        return dp[row][col];
    }
}
