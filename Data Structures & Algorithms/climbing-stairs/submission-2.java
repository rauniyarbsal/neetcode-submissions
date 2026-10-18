class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helper(n, 0, dp);
        
    }

    public int helper(int n, int i, int []dp){
        if(i == n) return 1;

        if(i > n) return 0;

        if(dp[i] != -1) return dp[i];

        dp[i] = helper(n, i + 1, dp) + helper(n, i + 2, dp); // recurrence relation

        return dp[i];
    }
}
