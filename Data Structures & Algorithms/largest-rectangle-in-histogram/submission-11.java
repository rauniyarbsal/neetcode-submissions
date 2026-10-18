class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0, nse = 0, pse = 0, currEle = 0;

        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                currEle = stack.pop();
                nse = i; pse = (stack.isEmpty()) ? -1 : stack.peek();

                maxArea = Math.max(maxArea, heights[currEle] * (nse - pse - 1));
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            currEle = stack.pop();
            nse = heights.length;
            pse = (stack.isEmpty()) ? -1 : stack.peek();

            maxArea = Math.max(maxArea, heights[currEle] * (nse - pse - 1));
        }

        return maxArea;
        
    }
}
