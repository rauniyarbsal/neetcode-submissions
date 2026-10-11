class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String token: tokens){
            if(token.equals("+") || token.equals("-")  || token.equals("*")  || token.equals("/") ){
                int b = stack.pop();
                int a = stack.pop();

                int res = solve(a, b, token);

                stack.push(res);
                
            }else{
                stack.push(Integer.parseInt(token));

            }

        }

        return stack.peek();
    }

    public static int solve(int a, int b, String token){
        if(token.equals("+")) return a + b;
        else if(token.equals("-")) return a - b;
        else if(token.equals("/")) return a / b;
        else return a * b;

    }
}
