class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans = new int[nums.length];

        // find prefix product from left to right
        int prefixProd = 1;
        for(int i=0;i<nums.length;i++){ // [1, 1, 2, 8]
            ans[i] = prefixProd;
            prefixProd *= nums[i];

        }

        // find suffix product from right to left
        int suffixProd = 1;
        for(int i = nums.length-1; i >= 0; i--){ // [48,24,12,8]
            ans[i] *= suffixProd;
            suffixProd *= nums[i];
        }

        return ans;
    }
}  






