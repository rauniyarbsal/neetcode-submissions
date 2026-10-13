class Solution {
    public String minWindow(String s, String t) {
        int startIdx = -1, minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int count = 0;

        if(s.length() < t.length()) return "";

        int []freqMap = new int[256];

        for(char ch: t.toCharArray()) freqMap[ch]++;

        while(r < s.length()){
            if(freqMap[s.charAt(r)] > 0) count++;

            freqMap[s.charAt(r)]--;

            while(count == t.length()){
                if(minLen > (r - l + 1)){
                    startIdx = l;
                    minLen = r - l + 1;

                }

                freqMap[s.charAt(l)]++;
                if(freqMap[s.charAt(l)] == 1) count--;

                l++;

            }

            r++;
        }


        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
