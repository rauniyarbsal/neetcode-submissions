class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        for(int x: nums){
            sum += x;

            maxSum = Math.max(sum, maxSum);

            if(sum < 0) sum = 0;
        }

        return maxSum;
        
    }
}
