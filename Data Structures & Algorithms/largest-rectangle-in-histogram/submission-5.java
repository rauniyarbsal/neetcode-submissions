class Solution {
    public int largestRectangleArea(int[] heights) {
        int []pse = prevSmallestEle(heights);
        int []nse = nextSmallestEle(heights);

        

        int area = 0, maxArea = 0;

        for(int i=0; i < heights.length;i++){
            area = heights[i] * (nse[i] - pse[i] - 1);

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public int[] prevSmallestEle(int []heights){
        Deque<Integer> stack = new ArrayDeque<>();

        int []pse = new int[heights.length];

        for(int i=0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();

            }

            pse[i] = (stack.isEmpty()) ? -1 : stack.peek();

            stack.push(i);
        }

        return pse;
    }

    public int[] nextSmallestEle(int []heights){
        Deque<Integer> stack = new ArrayDeque<>();

        int []nse = new int[heights.length];

        for(int i=heights.length-1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();

            }

            nse[i] = (stack.isEmpty()) ? heights.length : stack.peek();

            stack.push(i);
        }

        return nse;
    }
}
