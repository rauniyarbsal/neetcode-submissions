class Solution {
    public int trap(int[] height) {
        int n = height.length;

        //build leftMax array
        int []leftMax = new int[n];
        leftMax[0] = height[0];

        for(int i= 1; i < n;i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        }

        // build rightMax array
        int []rightMax = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        }

        int total_amt_water = 0, leftSupport = 0, rightSupport = 0;         
        int minSupport = 0;

        for(int i = 1; i < n-1; i++){
            leftSupport = leftMax[i];
            rightSupport = rightMax[i];

            minSupport = Math.min(leftSupport, rightSupport);

            total_amt_water += Math.max(0, minSupport - height[i]);

        }

        return total_amt_water;
        
    }
}
