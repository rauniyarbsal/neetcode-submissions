class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for(int x: nums){
            if(!hs.add(x)) return true;

        }

        return false;
    }
}