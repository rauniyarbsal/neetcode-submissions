class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][]dp = new int[coins.length][amount + 1];

        for(int []row: dp) Arrays.fill(row, -1);
        
        int ans = findChange(coins, 0, amount, dp);

        return (ans >= 100000)? -1: ans;
    }

    public int findChange(int []coins, int idx, int remainingAmt, int [][]dp){
        if(remainingAmt < 0 || idx >= coins.length) return 100000;

        if(remainingAmt == 0) return 0;

        if(dp[idx][remainingAmt] != -1) return dp[idx][remainingAmt];

        //2 case either take or skip, and each coin can consider unlimited times
        int take = 1 + findChange(coins, idx, remainingAmt - coins[idx], dp);
        int skip = findChange(coins, idx + 1, remainingAmt, dp);

        dp[idx][remainingAmt] = Math.min(take, skip);
        return dp[idx][remainingAmt];
    }
}
