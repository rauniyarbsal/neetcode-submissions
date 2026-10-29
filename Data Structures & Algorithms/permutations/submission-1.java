class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        findPermutation(nums, ans, new ArrayList<>());

        return ans;
    }

    public void findPermutation(int []nums, List<List<Integer>> ans, ArrayList<Integer> temp){

        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;

        }

        for(int i=0; i < nums.length; i++){
            if(temp.contains(nums[i])) continue;

            temp.add(nums[i]); // add

            findPermutation(nums, ans, temp); // explore

            temp.remove(temp.size()-1); // skip
        }


    }
}
