class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int []ans = new int[nums.length - k + 1];

        int l = 0, r = 0, idx = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        while(r < nums.length){
            while(!stack.isEmpty() && nums[r] >= nums[stack.peekLast()]){
                stack.pollLast();

            }

            stack.offerLast(r);

            if((r - l + 1) == k){
                ans[idx] = nums[stack.peekFirst()];
                idx++;

            }

            while((r - l + 1) >= k){
                if(stack.peekFirst() <= l){
                    stack.pollFirst();

                }

                l++;


            }

            r++;
        }

        return ans;
    }
}
