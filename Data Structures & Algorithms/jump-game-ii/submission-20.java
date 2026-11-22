class Solution {
    public int jump(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return minJump(nums, 0, dp);
    }

    public int minJump(int []nums, int idx, int []dp){
        if(idx >= nums.length-1){
            return 0;

        }

        if(dp[idx] != -1) return dp[idx];

        int minJump = Integer.MAX_VALUE;

        for(int jump = 1; jump <= nums[idx]; jump++){

            int next = minJump(nums, jump + idx, dp);

            if(next != Integer.MAX_VALUE){
                minJump = Math.min(minJump, 1 + next);

            }
        }

        dp[idx] = minJump;
        return dp[idx];
    }
}
