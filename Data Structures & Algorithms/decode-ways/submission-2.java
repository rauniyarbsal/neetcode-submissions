class Solution {
    public int numDecodings(String s) {
        int []dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return findWays(s, 0, dp);
    }

    public int findWays(String s, int idx, int []dp) {

        // Successfully consumed entire string
        if (idx >= s.length()) {
            return 1;
        }

        if(dp[idx] != -1) return dp[idx];

        // 0 cannot be decoded by itself
        if (s.charAt(idx) == '0') {
            dp[idx] = 0;

            return dp[idx];
        }

        // Choice 1: consume one digit
        int oneDigit = findWays(s, idx + 1, dp);

        // Choice 2: consume two digits
        int twoDigit = 0;

        if (idx + 1 < s.length()) {

            int num =
                (s.charAt(idx) - '0') * 10
                + (s.charAt(idx + 1) - '0');

            if (num >= 10 && num <= 26) {
                twoDigit = findWays(s, idx + 2, dp);
            }
        }

        dp[idx] =  oneDigit + twoDigit;

        return dp[idx];
    }

    /* 
        State → idx
Choices → consume 1 digit OR valid 2 digits
Success → reach end → 1 way
Invalid → current digit is 0 → 0 ways
Combine → oneDigit + twoDigit
Memo → dp[idx]
    
    */
}