class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> hs = new HashSet<>();
        
        explorePossibleSum(nums, target, new ArrayList<>(), hs, 0, 0);

        return new ArrayList<>(hs);
        
    }


    public void explorePossibleSum(int []nums, int target, List<Integer> tempSet, Set<List<Integer>> hs, int sum, int i){

        if(sum == target){
            hs.add(new ArrayList<>(tempSet));
            return;

        }

        if(sum > target || i >= nums.length){
            return;

        }

        tempSet.add(nums[i]);
        sum += nums[i];
        
        explorePossibleSum(nums, target, tempSet, hs, sum, i); // choose same num many no of times

        sum -= nums[i];
        tempSet.remove(tempSet.size()-1);

        explorePossibleSum(nums, target, tempSet, hs, sum, i + 1); // choose once and go a head to other idx


    }
}
