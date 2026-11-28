class Solution {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for(int currAmt = 1; currAmt <= amount; currAmt++){
            for(int coin: coins){

                if(coin <= currAmt){

                    dp[currAmt] = Math.min(dp[currAmt], 1 + dp[currAmt - coin]);
                }
            }
        }

        return (dp[amount] > amount) ? -1: dp[amount];
    }
}
