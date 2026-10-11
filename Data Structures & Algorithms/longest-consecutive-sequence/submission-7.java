class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        int maxLen = 0;

        for(int x: nums) hs.add(x);

        if(nums.length == 0) return 0;

        
        int i = 0;
        while(i < nums.length){ // find each start of sequence
            int x = nums[i];
            int count = 1;

            if(!hs.contains(x-1)){
                while(hs.contains(x + 1)){
                    count++;
                    x++;
                }

                maxLen = Math.max(maxLen, count);
            }
            
            i++;

        }

        return maxLen;
        
    }
}
