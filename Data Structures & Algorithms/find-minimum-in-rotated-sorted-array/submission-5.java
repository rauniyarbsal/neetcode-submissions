class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        int ans = Integer.MAX_VALUE;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(nums[lo] <= nums[hi]){
                ans = Math.min(ans, nums[lo]);
                return ans;

            }else{

                if(nums[lo] <= nums[mid]){
                    //left part is sorted, ignore right part
                    ans = Math.min(ans, nums[lo]);
                    lo = mid + 1;

                }else{
                    // right part is sorted mid to high, ignore left part
                    ans = Math.min(ans, nums[mid]);
                    hi = mid - 1;

                }

            }
        }

        return ans;
    }
}
