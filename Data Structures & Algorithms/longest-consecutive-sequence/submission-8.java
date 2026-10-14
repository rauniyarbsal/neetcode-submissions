class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int maxLen = 0;

        for(int x: nums) hs.add(x);

        for(int t: nums){
            
            if(!hs.contains(t-1)){
                int x = t;
                int count = 1;

                while(hs.contains(x + 1)){
                    x++;
                    count++;

                }

                maxLen = Math.max(maxLen, count);

            }

        }

        return maxLen;
        
    }
}
