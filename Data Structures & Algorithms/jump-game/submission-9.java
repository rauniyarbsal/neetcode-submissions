class Solution {
    public boolean canJump(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return reachLastIdx(nums, 0, dp);
    }

    public boolean reachLastIdx(int []nums, int idx, int []dp){
        if(idx >= nums.length - 1){

            return true;
        }

        if(dp[idx] != -1){
            
            return dp[idx] == 1;
        }

        if(nums[idx] == 0){
            dp[idx] = 0;

            return false;

        }

        for(int jump = 1; jump <= nums[idx]; jump++){
            if(reachLastIdx(nums, idx + jump, dp)){
                dp[idx] = 1;

                return true;
            }


        }
        
        dp[idx] = 0;
        return false;
    }
}
