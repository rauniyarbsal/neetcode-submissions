class Solution {
    public String longestPalindrome(String s) {
        int startIdx = -1;
        int maxLen = 0;
        
        for(int left=0;left<s.length();left++){
            for(int right = left; right < s.length(); right++){

                if(checkIfPalindrome(s, left, right)){

                    if((right - left + 1) > maxLen){
                        maxLen = right - left + 1;
                        startIdx = left;

                    }

                }
            }
        }

        return (startIdx == -1) ? "": s.substring(startIdx, startIdx + maxLen);
    }

    public boolean checkIfPalindrome(String s, int left, int right){
        if(left >= right) return true;

        if(s.charAt(left) != s.charAt(right)) return false;

        return checkIfPalindrome(s, left + 1, right - 1);
    }
}
