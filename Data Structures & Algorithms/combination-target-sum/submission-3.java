class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombination(nums, target, new ArrayList<>(), ans, 0, 0);

        return ans;
    }

    public void findCombination(
        int[] nums, int target, List<Integer> tempSet, List<List<Integer>> ans, int sum, int i) {
        if(sum == target){
            ans.add(new ArrayList<>(tempSet));
            return;

        }

        if(sum > target || i >= nums.length) return;

        tempSet.add(nums[i]); // choose
        sum += nums[i];

        findCombination(nums, target, tempSet, ans, sum, i); // explore

        sum -= nums[i];
        tempSet.remove(tempSet.size()-1);

        findCombination(nums, target, tempSet, ans, sum, i + 1); // backtrack
    }
}
