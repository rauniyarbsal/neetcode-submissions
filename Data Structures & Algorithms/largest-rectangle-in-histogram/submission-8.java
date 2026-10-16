class Solution {
    public int largestRectangleArea(int[] heights) {
        int []nse = findNSE(heights);
        int []pse = findPSE(heights);

        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1));

        }

        return maxArea;
    }

    public int[] findNSE(int []heights){
        Deque<Integer> stack = new ArrayDeque<>();

        int []nse = new int[heights.length];

        for(int i=heights.length-1; i >= 0; i--){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();

            }

            nse[i] = (stack.isEmpty()) ? heights.length: stack.peek();

            stack.push(i);
        }

        return nse;
    }

    public int[] findPSE(int []heights){
        Deque<Integer> stack = new ArrayDeque<>();

        int []pse = new int[heights.length];

        for(int i=0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();

            }

            pse[i] = (stack.isEmpty()) ? -1: stack.peek();

            stack.push(i);
        }

        return pse;
    }
}
