class Solution {
    public int[] countBits(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);

        int []ans = new int[n+1];
        int count = 0;

        ans[0] = 0;

        for(int i = 1; i <= n; i++){
            int x = i;

            if(dp[x] != -1){
                count += dp[x];
                ans[i] = count;
                count = 0;

                continue;
            }

            while(x > 0){
                x = x & (x - 1);
                count++;
                dp[x] = count;

            }

            ans[i] = count;
            count = 0;
        }
        
        return ans;
    }
}
