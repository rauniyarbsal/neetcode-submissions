class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == '0') continue;

                exploreAdj(grid, i, j);

                count++;

            }
        }

        return count;
        
    }

    public void exploreAdj(char [][]grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){ // base condition
            return;

        }

        grid[i][j] = '0'; // change current island to water then explore 4 dir

        // explore all 4 adjacent direction
        exploreAdj(grid, i - 1, j);
        exploreAdj(grid, i + 1, j);
        exploreAdj(grid, i, j - 1);
        exploreAdj(grid, i, j + 1);
    }
}
