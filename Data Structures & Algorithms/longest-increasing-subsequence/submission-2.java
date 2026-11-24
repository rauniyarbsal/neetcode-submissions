class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][]dp = new int[nums.length][nums.length + 1];
        for(int []row: dp) Arrays.fill(row, -1);

        return findLIS(nums, 0, -1, dp); // curr idx , prevIdx

    }

    public int findLIS(int []nums, int idx, int prevIdx, int [][]dp){
        if(idx >= nums.length){
            return 0;

        }

        if(dp[idx][prevIdx + 1] != -1){
            return dp[idx][prevIdx + 1];

        }

        // 1. skip
        int skip = findLIS(nums, idx + 1, prevIdx, dp);

        int take = 0;

        // 2. take
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){

            take = 1 + findLIS(nums, idx + 1, idx, dp);

        }
        
        dp[idx][prevIdx+1] = Math.max(take, skip);

        return dp[idx][prevIdx+1];
    }
}

/*
dp[idx][prevIdx + 1]

= longest increasing subsequence we can build
  starting from idx,
  given that prevIdx was the last selected index
*/
