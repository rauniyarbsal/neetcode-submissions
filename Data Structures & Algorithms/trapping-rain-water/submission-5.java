class Solution {
    public int trap(int[] height) {
        // first find left support + right support for each ele
        // then take min cause that will decide how much water will get stored in each building then calculate total_amt by taking difference net_support - height[i]
        int []leftMax = new int[height.length];
        leftMax[0] = height[0];

        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);

        }

        int []rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];

        for(int i = height.length-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);

        }

        int total_amt = 0, support_from_left = 0, support_from_right = 0;
        int net_support = 0;

        for(int i=1;i< height.length-1; i++){
            support_from_left = leftMax[i];
            support_from_right = rightMax[i];

            net_support = Math.min(support_from_left, support_from_right);
            
            total_amt += Math.max(0, net_support - height[i]);
        }

        return total_amt;
    }
}
