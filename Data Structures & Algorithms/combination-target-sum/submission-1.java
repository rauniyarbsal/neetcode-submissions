class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        explorePossibleSum(nums, target, new ArrayList<>(), ans, 0, 0);

        return ans;
        
    }


    public void explorePossibleSum(int []nums, int target, List<Integer> tempSet, List<List<Integer>> ans, int sum, int i){

        if(sum == target){
            ans.add(new ArrayList<>(tempSet));
            return;

        }

        if(sum > target || i >= nums.length){
            return;

        }

        tempSet.add(nums[i]);
        sum += nums[i];
        
        explorePossibleSum(nums, target, tempSet, ans, sum, i); // choose same num many no of times

        sum -= nums[i];
        tempSet.remove(tempSet.size()-1);

        explorePossibleSum(nums, target, tempSet, ans, sum, i + 1); // choose once and go a head to other idx


    }
}
