class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0, maxArea = 0;

        for(int i=0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                int currEle = stack.pop();
                int nse = i, pse = (stack.isEmpty()) ? -1 : stack.peek();

                area = heights[currEle] * (nse - pse - 1);

                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int currEle = stack.pop();

            int nse = heights.length, pse = (stack.isEmpty()) ? -1 : stack.peek();

            area = heights[currEle] * (nse - pse - 1);

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
