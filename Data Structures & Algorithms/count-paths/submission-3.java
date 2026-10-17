class Solution {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    // public void exploreGrid(int i , int j, int m, int n){
    //     if(i < 0 || j < 0){
    //         return;

    //     }

    //     if((i == 0) && (j == 0)){ //base condition
    //         count++;
    //         return;

    //     }

    //     //explore in 2 direction
    //     exploreGrid(i, j - 1, m , n);
    //     exploreGrid(i - 1, j, m , n);
    // }
}
