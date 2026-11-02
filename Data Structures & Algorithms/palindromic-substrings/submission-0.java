class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindromes
            // center is one character
            count += expand(s, i, i);

            // Even-length palindromes
            // center is between two characters
            count += expand(s, i, i + 1);
        }

        return count;
    }

    public int expand(String s, int left, int right) {
        int count = 0;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            // s[left...right] is a palindrome
            count++;

            // Expand outward
            left--;
            right++;
        }

        return count;
    }
}