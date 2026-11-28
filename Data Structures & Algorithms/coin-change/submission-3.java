class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int ans = findChange(coins, 0, amount);

        return (ans >= 100000)? -1: ans;
    }

    public int findChange(int []coins, int idx, int remainingAmt){
        if(remainingAmt < 0 || idx >= coins.length) return 100000;

        if(remainingAmt == 0) return 0;

        //2 case either take or skip, and each coin can consider unlimited times
        int take = 1 + findChange(coins, idx, remainingAmt - coins[idx]);
        int skip = findChange(coins, idx + 1, remainingAmt);

        return Math.min(take, skip);
    }
}
