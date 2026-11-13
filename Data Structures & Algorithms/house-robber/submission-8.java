class Solution {
    public int rob(int[] nums) {
        int twoBack = 0, oneBack = 0;

        for(int money: nums){

            int robCurr = money + twoBack;
            int skipCurr = oneBack;

            int curr = Math.max(robCurr, skipCurr);

            twoBack = oneBack;
            oneBack = curr;
        }

        return oneBack;
    }
}
