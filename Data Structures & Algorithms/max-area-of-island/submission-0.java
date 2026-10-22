class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j] == 0) continue;

                maxArea = Math.max(maxArea, exploreIsland(grid, i, j));

            }
        }
        
        return maxArea;
    }

    public int exploreIsland(int [][]grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;

        }

        grid[i][j] = 0;

        return 1 + exploreIsland(grid, i - 1, j) + 
        exploreIsland(grid, i + 1, j) +
        exploreIsland(grid, i, j - 1) + 
        exploreIsland(grid, i, j + 1);
    }   
}
