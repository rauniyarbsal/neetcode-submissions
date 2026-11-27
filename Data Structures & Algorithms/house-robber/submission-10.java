class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return maxRob(nums, 0, dp);
    }

    public int maxRob(int []nums, int idx, int []dp){
        if(idx >= nums.length){
            return 0;

        }

        if(dp[idx] != -1) return dp[idx];

        // 2 choices robber have either rob or skip
        int take = nums[idx] + maxRob(nums, idx + 2, dp);

        int skip = maxRob(nums, idx + 1, dp);

        dp[idx] = Math.max(take, skip);

        return dp[idx];
    }
}
