class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][]dp = new int[coins.length][amount + 1];
        for(int []row: dp) Arrays.fill(row, -1);
        
        int ans = findMin(coins, amount, 0, dp);

        return (ans >= 100000) ? -1 : ans;
    }

    public int findMin(int []coins, int remAmount, int idx, int [][]dp){

        if(remAmount == 0) return 0;

        if(remAmount < 0 || idx >= coins.length) return 100000;

        if(dp[idx][remAmount] != -1) return dp[idx][remAmount];

        int take = 1 + findMin(coins, remAmount - coins[idx], idx, dp);

        int skip = findMin(coins, remAmount, idx + 1, dp);

        dp[idx][remAmount] = Math.min(take, skip);

        return dp[idx][remAmount];
    }
}
