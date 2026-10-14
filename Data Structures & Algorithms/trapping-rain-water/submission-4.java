class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;

        int total_amt = 0;

        while(left < right){
            if(height[left] <= height[right]){

                if(height[left] >= leftMax){ //Tallest bar I've encountered so far from the left.
                    leftMax = height[left];

                }else{
                    total_amt += Math.max(0, leftMax - height[left]);

                }

                left++;
            }else{

                if(height[right] >= rightMax){ //Tallest bar I've encountered so far from the right.
                    rightMax = height[right];
                }else{
                    total_amt += Math.max(0, rightMax - height[right]);

                }

                right--;

            }
        }

        return total_amt;
    }
}
