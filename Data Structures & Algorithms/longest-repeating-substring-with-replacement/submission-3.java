class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        int maxFreq = 0;

        int []freqMap = new int[26];

        while(r < s.length()){
            freqMap[s.charAt(r) - 'A']++;

            maxFreq = Math.max(maxFreq, freqMap[s.charAt(r) - 'A']);

            if((r - l + 1) - maxFreq > k){
                freqMap[s.charAt(l) - 'A']--;
                l++;

            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;

        }


        return maxLen;
        
    }
}
