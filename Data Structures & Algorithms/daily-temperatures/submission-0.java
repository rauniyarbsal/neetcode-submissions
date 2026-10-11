class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int []nextGreaterEle = new int[temperatures.length];

        for(int i=temperatures.length-1; i >= 0;i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();

            }

            nextGreaterEle[i] = (stack.isEmpty()) ? 0 : (stack.peek() - i);

            stack.push(i);
        }

        return nextGreaterEle;
        
    }
}
