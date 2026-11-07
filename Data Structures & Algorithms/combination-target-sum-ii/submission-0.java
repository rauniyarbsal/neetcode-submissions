class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        findUniqueCombination(candidates, target, new ArrayList<>(), ans, 0, 0);

        return ans;
    }


    public void findUniqueCombination(int []candidates, int target, List<Integer> tempSet, List<List<Integer>> ans, int sum, int i){

        if(sum == target){
            ans.add(new ArrayList<>(tempSet));
            return;

        }

        if(sum > target || i >= candidates.length) return;

        //take choice
        tempSet.add(candidates[i]); 
        findUniqueCombination(candidates, target, tempSet, ans, sum + candidates[i], i + 1);

        //skip choice
        tempSet.remove(tempSet.size()-1);
        
        int nextIdx = i + 1;

        while(nextIdx < candidates.length && candidates[i] == candidates[nextIdx]){
            nextIdx++;

        }

        findUniqueCombination(candidates, target, tempSet, ans, sum, nextIdx);
    }
}
