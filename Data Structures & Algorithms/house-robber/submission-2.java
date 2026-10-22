class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return maxRob(nums, 0, dp);
        
    }

    public int maxRob(int []nums, int i, int []dp){
        if(i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        // for each ele , have 2 choices either take it or skip it.
        int robCurr = nums[i] + maxRob(nums, i + 2, dp);
        int skipCurr = maxRob(nums, i + 1, dp);

        dp[i] = Math.max(robCurr, skipCurr);

        return dp[i];
    }
}
