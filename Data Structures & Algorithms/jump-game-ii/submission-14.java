class Solution {
    public int jump(int[] nums) {
        int currEnd = 0, farthest = 0, jumps = 0;

        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(farthest >= nums.length-1) return jumps + 1;

            if(i == currEnd){
                jumps++;
                currEnd = farthest;

            }



        }

        return jumps;
    }
}
