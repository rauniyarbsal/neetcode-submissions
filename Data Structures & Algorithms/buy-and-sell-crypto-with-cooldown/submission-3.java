class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        /*
            dp[i][0] → answer at day i when NOT holding
            dp[i][1] → answer at day i when holding

        */

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return findMaxProfit(prices, 0, false, dp);
    }

    public int findMaxProfit(int []prices, int i, boolean holding, int [][]dp){
        if(i >= prices.length){ // no days left
            return 0;

        }

        int state = holding ? 1 : 0;

        if(dp[i][state] != -1) return dp[i][state];

        if(!holding){ // 2 choices buy or skip

            int buy = - prices[i] + findMaxProfit(prices, i + 1, true, dp); // buy, hold

            int skip = findMaxProfit(prices, i + 1, false, dp);

            dp[i][state] = Math.max(buy, skip);


        }else{ // if own stock then 2 choices left is sell or hold

            int sell = prices[i] + findMaxProfit(prices, i + 2, false, dp);

            int skip = findMaxProfit(prices, i + 1, true, dp);

            dp[i][state] = Math.max(sell, skip);
        }

        return dp[i][state];
    }
}
