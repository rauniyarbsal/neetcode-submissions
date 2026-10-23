class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int x: nums) set.add(x);

        int count = 0, maxLen = 0;

        for(int t: nums){
            if(!set.contains(t - 1)){
                int x = t;
                count = 1;

                while(set.contains(x + 1)){
                    count++;
                    x++;

                }

                maxLen = Math.max(maxLen, count);
                count = 0;
            }
        }

        return maxLen;
        
    }
}
