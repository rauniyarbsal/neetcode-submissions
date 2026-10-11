class Solution {
    public int trap(int[] height) {
        // //T.C = O(N) and S.C = O(N) using prefix sum approach
        // int n = height.length;

        // //build leftMax array
        // int []leftMax = new int[n];
        // leftMax[0] = height[0];

        // for(int i= 1; i < n;i++){
        //     leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        // }

        // // build rightMax array
        // int []rightMax = new int[n];
        // rightMax[n-1] = height[n-1];

        // for(int i = n - 2; i >= 0; i--){
        //     rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        // }

        // int total_amt_water = 0, leftSupport = 0, rightSupport = 0;         
        // int minSupport = 0;

        // for(int i = 1; i < n-1; i++){
        //     leftSupport = leftMax[i];
        //     rightSupport = rightMax[i];

        //     minSupport = Math.min(leftSupport, rightSupport);

        //     total_amt_water += Math.max(0, minSupport - height[i]);

        // }

        // return total_amt_water;

        // using 2 pointer approach takes T.C = O(N) and S.C = O(1)
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int total = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];

                }else{
                    total += leftMax - height[left];

                }

                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];

                }else{
                    total += rightMax - height[right];

                }

                right--;
            }

        }

        return total;
        
    }
}
