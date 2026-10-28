class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Left → Pacific
        // Right → Atlantic
        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific);
            dfs(heights, row, cols - 1, atlantic);
        }

        // Top → Pacific
        // Bottom → Atlantic
        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific);
            dfs(heights, rows - 1, col, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Cells reachable from BOTH
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (pacific[row][col] &&
                    atlantic[row][col]) {

                    ans.add(Arrays.asList(row, col));
                }
            }
        }

        return ans;
    }


    public void dfs(
        int[][] heights,
        int row,
        int col,
        boolean[][] visited
    ) {

        visited[row][col] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Out of bounds
            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            // Already discovered
            if (visited[newRow][newCol]) {
                continue;
            }

            // Reverse water flow:
            // move to equal or HIGHER elevation
            if (heights[newRow][newCol] >= heights[row][col]) {

                dfs(
                    heights,
                    newRow,
                    newCol,
                    visited
                );
            }
        }
    }
}