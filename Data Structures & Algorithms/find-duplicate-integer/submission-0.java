class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for(int x: nums){
            if(!hs.add(x)) return x;

        }

        return -1;
    }
}
