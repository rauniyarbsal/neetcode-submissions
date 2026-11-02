class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        findSubset(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void findSubset(int []nums, int idx, ArrayList<Integer> tempSet, List<List<Integer>> ans){

        if(idx == nums.length){
            ans.add(new ArrayList<>(tempSet));
            return;

        }

        // take condition
        tempSet.add(nums[idx]); // consider 

        findSubset(nums, idx + 1, tempSet, ans); // explore

        tempSet.remove(tempSet.size()-1); // backtrack


        // skip condition below as:
        int nextIdx = idx + 1;

        while(nextIdx < nums.length && nums[nextIdx] == nums[idx]){
            nextIdx++;

        }

        findSubset(nums, nextIdx, tempSet, ans);
    }
}
