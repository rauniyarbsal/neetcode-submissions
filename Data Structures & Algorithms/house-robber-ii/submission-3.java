class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int []dp1 = new int[nums.length];
        int []dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // case 1 rob
        int case1 = robMaxAmount(nums, 0, nums.length-2, dp1);

        // case 2 skip
        int case2 = robMaxAmount(nums, 1, nums.length-1, dp2);

        return Math.max(case1, case2);
    }

    public int robMaxAmount(int []nums, int idx, int end, int []dp){
        if(idx > end) return 0;

        if(dp[idx] != -1) return dp[idx];

        // Choice 1: rob current house
        int rob =
            nums[idx] + robMaxAmount(nums, idx + 2, end, dp);

        // Choice 2: skip current house
        int skip =
            robMaxAmount(nums, idx + 1, end, dp);

        dp[idx] = Math.max(rob, skip);

        return dp[idx];
    }
}
