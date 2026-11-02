class Solution {

    int start = 0;
    int maxLen = 1;

    public String longestPalindrome(String s) {
        
        for(int i = 0; i < s.length(); i++){

            //oddlength palindrome
            expand(s, i, i);

            //even length palindrome
            expand(s, i, i+1);
        }

        return s.substring(start, start + maxLen);
    }

    public void expand(String s, int left, int right){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){

            int currLen = right - left + 1;

            if(currLen > maxLen){
                maxLen = currLen;
                start = left;

            }

            left--;
            right++;
        }
    }
}
