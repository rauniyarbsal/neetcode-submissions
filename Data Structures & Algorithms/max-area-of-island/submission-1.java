class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, findArea(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int findArea(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        if(grid[i][j] == 1) grid[i][j] = 0;

        int count = 1 + findArea(grid, i - 1, j) + findArea(grid, i + 1, j)
            + findArea(grid, i, j - 1) + findArea(grid, i, j + 1);

        return count;
    }
}
