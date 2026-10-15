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





    }
}
