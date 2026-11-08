class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp = new int[text1.length()][text2.length()];
        for(int []row: dp){
            Arrays.fill(row, -1);

        }

        return findLongCommon(text1, text2, 0, 0, dp);
    }

    public int findLongCommon(String s1, String s2, int i, int j, int [][]dp){
        if(i >= s1.length() || j >= s2.length()){
            
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        // two choice, when both char matches, then move both pointer if not, then just move any one pointer

        if(s1.charAt(i) == s2.charAt(j)){

            dp[i][j] = 1 + findLongCommon(s1, s2, i + 1, j + 1, dp);

            return dp[i][j];
        }
        
        // if they dont match then we dont' know which char should be skipped
        int skip1 = findLongCommon(s1, s2, i, j + 1, dp);
        int skip2 = findLongCommon(s1, s2, i + 1, j, dp);


        dp[i][j] = Math.max(skip1, skip2);

        return dp[i][j];
    }
}
