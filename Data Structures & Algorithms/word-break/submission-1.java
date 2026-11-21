class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return canBreak(s, wordDict, 0, dp);
    }

    public boolean canBreak(String s, List<String> wordDict, int idx, int[] dp) {
        if (idx >= s.length())
            return true;

        if (dp[idx] != -1) {
            return dp[idx] == 1;
        }

        for (String word : wordDict) { // for current index, try every word in wordDict

            if ((idx + word.length() <= s.length())
                && (s.substring(idx, idx + word.length()).equals(word))) {
                if (canBreak(s, wordDict, idx + word.length(), dp)) {
                    dp[idx] = 1;
                    return true;
                }
            }

        }

        dp[idx] = 0;
        return false;
    }
}

/*

    dp[idx] = -1 → haven't solved this index
dp[idx] =  1 → yes, remaining string can be broken
dp[idx] =  0 → no, remaining string cannot be broken
*/
