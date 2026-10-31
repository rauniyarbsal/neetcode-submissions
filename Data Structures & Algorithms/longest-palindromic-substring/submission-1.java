class Solution {
    public String longestPalindrome(String s) {
        int [][]dp = new int[s.length()][s.length()];
        int startIdx = -1;
        int maxLen = 0;
        
        for(int left=0;left<s.length();left++){
            for(int right = left; right < s.length(); right++){

                if(checkIfPalindrome(s, left, right, dp)){

                    if((right - left + 1) > maxLen){
                        maxLen = right - left + 1;
                        startIdx = left;

                    }

                }
            }
        }

        return (startIdx == -1) ? "": s.substring(startIdx, startIdx + maxLen);
    }

    public boolean checkIfPalindrome(String s, int left, int right, int [][]dp){
        if(left >= right) return true;

        if(dp[left][right] != 0){

            return dp[left][right] == 1;
        }

        if(s.charAt(left) != s.charAt(right)){
            dp[left][right] = -1;
            return false;

        }

        boolean inside = checkIfPalindrome(s, left + 1, right - 1, dp);

        dp[left][right] = inside ? 1: -1;

        return inside;
    }
}
