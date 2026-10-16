class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        int l = 0, r = 0;

        int []freqMap = new int[256];

        int startIdx = -1, minLen = Integer.MAX_VALUE, count = 0;

        for(char ch: t.toCharArray()) freqMap[ch]++;

        while(r < s.length()){
            if(freqMap[s.charAt(r)] > 0) count++;
            freqMap[s.charAt(r)]--;

            while(count == t.length()){
                if(count == t.length()){
                    if(minLen > (r - l + 1)){
                        startIdx = l;
                        minLen = r - l + 1;

                    }
                }

                freqMap[s.charAt(l)]++;

                if(freqMap[s.charAt(l)] > 0) count--;

                l++;
            }

            r++;

        }

        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLen);
        
    }
}
