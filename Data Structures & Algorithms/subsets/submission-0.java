class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(ans, new ArrayList<>(), nums, 0);

        return ans;
    }


    public void helper(List<List<Integer>> ans, List<Integer> tempSet, int []nums, int start){

        ans.add(new ArrayList<>(tempSet));
        
        for(int i = start; i < nums.length; i++){
            tempSet.add(nums[i]); // include the num

            helper(ans, tempSet, nums, i + 1); // explore

            tempSet.remove(tempSet.size() - 1); // backtrack

        }
    }
}
