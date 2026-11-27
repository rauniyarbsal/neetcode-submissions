class Solution {
    public int rob(int[] nums) {
        int oneBack = 0, twoBack = 0;

        int curr = 0;

        for(int money: nums){
            int robCurr = money + twoBack;
            int skipCurr = oneBack;

            curr = Math.max(robCurr, skipCurr);

            twoBack = oneBack;
            oneBack = curr;
        }

        return oneBack;
    }
}
