class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int case1 = robRange(nums, 0, nums.length-2);
        int case2 = robRange(nums, 1, nums.length-1);

        return Math.max(case1, case2);
    }

    public int robRange(int []nums, int start, int end){
        int oneBack = 0, twoBack = 0;

        for(int i=start; i <= end; i++){
            int rob = nums[i] + twoBack;
            int skip = oneBack;

            int curr = Math.max(rob, skip);

            twoBack = oneBack;
            oneBack = curr;
        }

        return oneBack;
    }
}
/*
    Circular problem
      ↓
    split into 2 linear problems

    [0 ........ n-2] → House Robber I
    [1 ........ n-1] → House Robber I
                            ↓
                    max(case1, case2)
*/