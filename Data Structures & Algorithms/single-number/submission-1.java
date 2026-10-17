class Solution {
    public int singleNumber(int[] nums) {
        // taking xor will cancel same numbers and give numbers when ^ 0

        int unique = nums[0];

        for(int i = 1; i < nums.length; i++){

            unique ^=  nums[i];
        }


        return unique;
        
    }
}
