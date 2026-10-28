class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        // Try every cell as the starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                boolean[][] visitedPacific = new boolean[rows][cols];
                boolean[][] visitedAtlantic = new boolean[rows][cols];

                boolean pacific = canReachPacific(
                    heights, i, j, visitedPacific
                );

                boolean atlantic = canReachAtlantic(
                    heights, i, j, visitedAtlantic
                );

                if (pacific && atlantic) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }


    // Can water from (row,col) reach Pacific?
    public boolean canReachPacific(
        int[][] heights,
        int row,
        int col,
        boolean[][] visited
    ) {

        // Pacific touches top row and left column
        if (row == 0 || col == 0) {
            return true;
        }

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

            // Check boundaries
            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            // Don't reuse same cell
            if (visited[newRow][newCol]) {
                continue;
            }

            // Normal water flow:
            // next cell must be <= current cell
            if (heights[newRow][newCol] <= heights[row][col]) {

                if (canReachPacific(
                    heights, newRow, newCol, visited
                )) {
                    return true;
                }
            }
        }

        return false;
    }


    // Can water from (row,col) reach Atlantic?
    public boolean canReachAtlantic(
        int[][] heights,
        int row,
        int col,
        boolean[][] visited
    ) {

        int rows = heights.length;
        int cols = heights[0].length;

        // Atlantic touches bottom row and right column
        if (row == rows - 1 || col == cols - 1) {
            return true;
        }

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

            if (newRow < 0 || newRow >= rows ||
                newCol < 0 || newCol >= cols) {
                continue;
            }

            if (visited[newRow][newCol]) {
                continue;
            }

            // Water flows downhill/equal
            if (heights[newRow][newCol] <= heights[row][col]) {

                if (canReachAtlantic(
                    heights, newRow, newCol, visited
                )) {
                    return true;
                }
            }
        }

        return false;
    }
}