class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int []ans = new int[2];

        int lo = 0, hi = numbers.length-1;

        while(lo < hi){
            int total = numbers[lo] + numbers[hi];

            if(total == target){
                ans[0] = lo + 1;
                ans[1] = hi + 1;

                return ans;

            }else if(total < target) lo = lo + 1;
            else{
                hi = hi - 1;

            }
        }

        return ans;
    }
}
