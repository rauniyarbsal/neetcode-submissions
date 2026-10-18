class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int []dp = new int[cost.length];
        Arrays.fill(dp, -1);

       return Math.min(explore(cost, 0, dp), explore(cost, 1, dp));
        
    }

    public int explore(int []cost, int i, int []dp){
        if(i >= cost.length){
            return 0;

        }

        if(dp[i] != -1) return dp[i];

        int oneStep = explore(cost, i + 1, dp);
        int twoStep = explore(cost, i + 2, dp);

        dp[i] = cost[i] + Math.min(oneStep, twoStep);
        
        return dp[i];
    }
}
