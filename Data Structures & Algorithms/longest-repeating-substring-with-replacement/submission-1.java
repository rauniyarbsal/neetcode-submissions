class Solution {
    public int characterReplacement(String s, int k) {
        int []freq = new int[26];
        int l = 0, r = 0;
        int maxLen = 0, maxFreq = 0;


        for(r=0;r<s.length();r++){
            int idx = s.charAt(r) - 'A';
            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            while((r - l + 1) - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;

            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
