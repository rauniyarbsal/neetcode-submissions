class Solution {
    public int change(int amount, int[] coins) {
        int [][]dp = new int[coins.length][amount + 1];
        for(int []row: dp) Arrays.fill(row, -1);

        int ans = findMinChange(amount, coins, 0, dp);

        return ans;
        
    }

    public int findMinChange(int remAmount, int []coins, int idx, int [][]dp){
        if(remAmount == 0) return 1;

        if(remAmount < 0 || idx >= coins.length) return 0;

        if(dp[idx][remAmount] != -1) return dp[idx][remAmount];

        int take = findMinChange(remAmount - coins[idx], coins, idx, dp);

        int skip = findMinChange(remAmount, coins, idx + 1, dp);

        dp[idx][remAmount] = take + skip;

        return dp[idx][remAmount]; // total ways
    }
}
