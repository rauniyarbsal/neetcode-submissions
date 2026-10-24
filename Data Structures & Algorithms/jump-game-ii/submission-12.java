class Solution {

    public int jump(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return findMinJump(nums, 0, dp);
        
    }

    public int findMinJump(int []nums, int idx, int []dp){
        if(idx >= nums.length-1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int minJump = Integer.MAX_VALUE;

        for(int jump = 1; jump <= nums[idx] && idx + jump < nums.length; jump++){

            int currJump = findMinJump(nums, idx + jump, dp);

            minJump = Math.min(minJump, currJump);

        }

        if(minJump == Integer.MAX_VALUE) return minJump;


        dp[idx] = 1 + minJump;
        
        return dp[idx];
    }
}
