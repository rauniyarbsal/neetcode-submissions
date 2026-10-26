class Solution {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for(int currAmount = 1; currAmount <= amount; currAmount++){
            for(int coin: coins){
                if(coin <= currAmount){

                    dp[currAmount] = Math.min(dp[currAmount], 1 + dp[currAmount - coin]);
                }
            }
        }

        return (dp[amount] > amount) ? -1 : dp[amount];
        
    }
}
