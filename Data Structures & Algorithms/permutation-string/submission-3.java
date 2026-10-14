class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int []freqMap = new int[26];

        if(s1.length() > s2.length()) return false;

        for(char ch: s1.toCharArray()) freqMap[ch - 'a']++;

        for(int i = 0; i < s1.length(); i++){
            freqMap[s2.charAt(i) - 'a']--;

        }

        int flag = 1;

        for(int i = 0; i < 26; i++){
            if(freqMap[i] != 0){
                flag = 0;

            }

        }

        if(flag == 1) return true;

        int l = 0, r = s1.length();
        flag = 1;

        while(r < s2.length()){
            freqMap[s2.charAt(l) - 'a']++;
            l++;

            freqMap[s2.charAt(r) - 'a']--;
            r++;

            for(int i=0; i < 26; i++){
                if(freqMap[i] != 0){
                    flag = 0;

                }

            }

            if(flag == 1) return true;

            flag = 1;
        }

        return false;
    }
}
