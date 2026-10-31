class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;

        for(int i=0; i <= nums.length; i++) sum += i;

        int findMissingNum = 0;

        for(int num: nums) findMissingNum += num;

        return sum - findMissingNum; 
    }
}
