class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans = new int[nums.length];

        int prefixProd = 1;
        for(int i=0; i < nums.length; i++){ // build left Prod
            ans[i] = prefixProd;
            prefixProd *= nums[i];

        }

        int suffixProd = 1;
        for(int i=nums.length-1; i >= 0; i--){ // build right Prod
            ans[i] *= suffixProd;
            suffixProd *= nums[i];

        }

        return ans;
        
    }
}  
