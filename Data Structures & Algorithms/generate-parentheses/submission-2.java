class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        helper(new StringBuilder(), n, 0, 0, ans);

        return ans;
    }


    public void helper(StringBuilder sb, int n, int open, int close, List<String> ans){
        if(open == n && close == n) { // base condition
            ans.add(sb.toString());
            return;

        }

        if(open < n){
            sb.append("("); // choose

            helper(sb, n, open + 1, close, ans); // explore

            sb.deleteCharAt(sb.length()-1); // undo

        }

        if(close < open){
            sb.append(")");

            helper(sb, n, open, close + 1, ans);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
