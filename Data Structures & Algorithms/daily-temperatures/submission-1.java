class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int []nge = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = temperatures.length-1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();

            }

            nge[i] = (stack.isEmpty()) ? 0 : stack.peek() - i;

            stack.push(i);
        }

        return nge;
    }
}
