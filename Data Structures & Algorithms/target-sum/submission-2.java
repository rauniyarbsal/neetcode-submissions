class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

        return findPossibleWays(nums, target, 0, 0, memo);
    }

    public int findPossibleWays(
        int[] nums, int target, int idx, int sum, Map<Integer, Map<Integer, Integer>> memo) {
        if (idx >= nums.length) {
            if (sum == target)
                return 1;

            return 0;
        }

        // Already calculated (idx, sum)
        if (memo.containsKey(idx) && memo.get(idx).containsKey(sum)) {
            return memo.get(idx).get(sum);
        }

        // 2 choices
        int add = findPossibleWays(nums, target, idx + 1, sum + nums[idx], memo);
        int sub = findPossibleWays(nums, target, idx + 1, sum - nums[idx], memo);

        int ways = add + sub;

        memo.computeIfAbsent(idx, k -> new HashMap<>()).put(sum, ways);

        return ways;
    }
}
