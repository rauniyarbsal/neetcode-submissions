class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findPossibleWays(nums, target, ans, new ArrayList<>(), 0);

        return ans;
    }

    public void findPossibleWays(int []nums, int target, List<List<Integer>> ans, List<Integer> tempSet, int index){
        if(target == 0){
            ans.add(new ArrayList<>(tempSet));
            return;
            
        }

        if(target < 0 || index >= nums.length) return;

        tempSet.add(nums[index]); // choose

        //two case 
        findPossibleWays(nums, target - nums[index], ans, tempSet, index); //explore

        tempSet.remove(tempSet.size() - 1); // backtrack

        findPossibleWays(nums, target, ans, tempSet, index + 1);

        
    }
}
