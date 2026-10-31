class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int []ans = new int[nums.length];

        // build left product
        int prefixProd = 1;
        for(int i=0; i < nums.length; i++){
            ans[i] = prefixProd; // [1, 1, 2, 8]
            prefixProd *= nums[i];

        }


        // build right product and finalize answer 
        int suffixProd = 1;
        for(int i = nums.length-1; i >= 0; i--){
            ans[i] *= suffixProd;
            suffixProd *= nums[i];

        }


        return ans;
    }
}  
