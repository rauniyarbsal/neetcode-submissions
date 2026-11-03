class Solution {
    public int characterReplacement(String s, int k) {
        int []freqMap = new int[26];

        int l = 0, r = 0;
        int maxLen = 0, maxFreq = 0;

        while(r < s.length()){
            int idx = s.charAt(r) - 'A';
            freqMap[idx]++;

            maxFreq = Math.max(maxFreq, freqMap[idx]);

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
