class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int flag = 1;

        int []freq = new int[26];

        for(char ch: s1.toCharArray()) freq[ch - 'a']++;

        int n = s1.length();

        if(s1.length() > s2.length()) return false;

        for(int i=0; i < n; i++){
            freq[s2.charAt(i) - 'a']--;

        }

        for(int i=0; i < 26; i++) {
            if(freq[i] != 0){
                flag = 0;
                break;

            }

        }

        if(flag == 1) return true;

        int l = 0, r = n;

        while(r < s2.length()){
            freq[s2.charAt(l) - 'a']++;
            l++;

            freq[s2.charAt(r) - 'a']--;
            r++;

            flag = 1;

            for(int i=0; i < 26; i++) {
                if(freq[i] != 0) flag = 0;

            }

            if(flag == 1) return true;

        }

        return false;
    }
}
