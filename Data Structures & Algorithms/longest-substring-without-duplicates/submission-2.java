class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []freqMap = new int[256];
        Arrays.fill(freqMap, -1);

        int l = 0, r = 0;
        int maxLen = 0;

        while(r < s.length()){
            if(freqMap[s.charAt(r)] >= 0){
                l = Math.max(l, freqMap[s.charAt(r)] + 1);

            }
            

            freqMap[s.charAt(r)] = r;
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
        
    }
}
