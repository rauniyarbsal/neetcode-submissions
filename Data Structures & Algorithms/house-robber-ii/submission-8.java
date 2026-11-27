class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        //case 1: rob
        int case1 = maxRob(nums, 0, nums.length-2);

        // case 2: skip
        int case2 = maxRob(nums, 1, nums.length-1);

        return Math.max(case1, case2);
    }

    public int maxRob(int []nums, int idx, int end){
        int oneBack = 0, twoBack = 0;
        int curr = 0;

        for(int start = idx; start <= end; start++){
            int robCurr = nums[start] + twoBack;
            int skipCurr = oneBack;

            curr = Math.max(robCurr, skipCurr);

            twoBack = oneBack;
            oneBack = curr;
        }

        return oneBack;
    }
}
