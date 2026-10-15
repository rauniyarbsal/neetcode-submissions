class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        helper(new StringBuilder(), 0, 0, n, ans);

        return ans;
    }

    public void helper(StringBuilder currString, int open, int close, int n, List<String> ans){
        if(open == n && close == n){ // base condition
            ans.add(currString.toString());
            return;

        }

        if(open < n){ 
            currString.append("("); // choose

            helper(currString, open + 1, close, n, ans); // explore
            /// I'm thinking of how to undo the changes I did above
            currString.deleteCharAt(currString.length() - 1); // undo


        }


        if(close < open){
            currString.append(")");
          
            helper(currString, open, close + 1, n, ans);

            currString.deleteCharAt(currString.length() - 1);

        }


/*
    “I'm using backtracking. At each step, I can potentially add an opening or closing parenthesis. I only add ( if I haven't used all n opening parentheses, and I only add ) when the number of closing parentheses used is less than the number of opening parentheses, so I never generate an invalid prefix. Once I've used n opening and n closing parentheses, I add the current string to the result.”

For complexity, say:
“The number of valid combinations is the nth Catalan number, Cₙ. Since each generated string has length 2n, the time complexity is O(n × Cₙ). The auxiliary space is O(n) because the recursion depth and current string are at most 2n. If we include the returned output, the space is O(n × Cₙ).”
*/


    }
}
