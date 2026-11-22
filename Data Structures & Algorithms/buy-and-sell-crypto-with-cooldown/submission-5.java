class Solution {
    public int maxProfit(int[] prices) {
        int [][]dp = new int[prices.length][2];
        for(int []row: dp){
            Arrays.fill(row, -1);

        }

        return findMaxProfit(prices, 0, false, dp);

    }

    public int findMaxProfit(int []prices, int i, boolean holding, int [][]dp){
        if(i >= prices.length){
            return 0;

        }

        int state = holding ? 1 : 0;

        if(dp[i][state] != -1){
            return dp[i][state];

        }

        // 2 cases whether we hold stock or not
        if(!holding){
            // if not holding then we will have 2 case either buy or skip stock
            int buy = -prices[i] + findMaxProfit(prices, i + 1, true, dp);

            int skip = findMaxProfit(prices, i + 1, false, dp);

            dp[i][state] = Math.max(buy, skip);
            return dp[i][state];


        }else{
            //if holding then will have 2 case either sell or skip
            int sell = prices[i] + findMaxProfit(prices, i + 2, false, dp);

            int skip = findMaxProfit(prices, i + 1, true, dp);

            dp[i][state] = Math.max(sell, skip);
            return dp[i][state];
        }
    }
}
