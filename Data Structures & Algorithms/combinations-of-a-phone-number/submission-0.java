class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();

        findLetterCombination(digits, keypad, new StringBuilder(), ans, 0);

        return ans;
    }

    public void findLetterCombination(String digits, String []keypad, StringBuilder curr, List<String> ans, int idx){
        if(idx == digits.length()){
            ans.add(curr.toString());
            return;

        }


        int digit = digits.charAt(idx) - '0';

        String letters = keypad[digit];

        for(char ch: letters.toCharArray()){
            curr.append(ch);

            findLetterCombination(digits, keypad, curr, ans, idx + 1);

            curr.deleteCharAt(curr.length()-1);

        }


    }
}
