class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for(int i=1; i < nums.length; i++){

            int x = nums[i];

            //Save previous state
            int prevMax = currMax;
            int prevMin = currMin;

            // 3 possibilities
            int startFresh = x;
            int extendMax = prevMax * x;
            int extendMin = prevMin * x;

            // Best product ending here
            currMax = Math.max(startFresh, Math.max(extendMax, extendMin));
            currMin = Math.min(startFresh, Math.min(extendMax, extendMin));

            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}
