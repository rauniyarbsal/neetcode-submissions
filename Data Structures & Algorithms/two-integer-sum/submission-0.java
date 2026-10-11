class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int []ans = new int[2];

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];

            if(mp.containsKey(diff)){
                ans[0] = mp.get(diff);
                ans[1] = i;

            }else{
                mp.put(nums[i], i);

            }
        }

        return ans;
        
    }
}
