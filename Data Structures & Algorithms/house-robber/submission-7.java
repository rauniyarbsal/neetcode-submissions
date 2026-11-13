class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return findMax(nums, 0, dp);
    }

    public int findMax(int []nums, int idx, int []dp){
        if(idx >= nums.length){
            return 0;

        }

        if(dp[idx] != -1) return dp[idx];

        int take = nums[idx] + findMax(nums, idx + 2, dp);
        int skip = findMax(nums, idx + 1, dp);

        dp[idx] = Math.max(take, skip);
        return dp[idx];
    }
}
