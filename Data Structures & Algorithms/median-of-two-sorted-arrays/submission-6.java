class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Binary-search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int half = (m + n + 1) / 2; // We want the left partition to contain the median when the total is odd.

        int lo = 0;
        int hi = m;

        while (lo <= hi) {

            // Partition in nums1
            int partition1 = lo + (hi - lo) / 2;

            // Partition in nums2 is automatically determined
            int partition2 = half - partition1;

            // Four boundary values
            int L1 = (partition1 == 0)
                ? Integer.MIN_VALUE
                : nums1[partition1 - 1];

            int R1 = (partition1 == m)
                ? Integer.MAX_VALUE
                : nums1[partition1];

            int L2 = (partition2 == 0)
                ? Integer.MIN_VALUE
                : nums2[partition2 - 1];

            int R2 = (partition2 == n)
                ? Integer.MAX_VALUE
                : nums2[partition2];

            // Correct partition
            if (L1 <= R2 && L2 <= R1) {

                // Odd total
                if ((m + n) % 2 == 1) {
                    return Math.max(L1, L2);
                }

                // Even total
                return (
                    Math.max(L1, L2) +
                    Math.min(R1, R2)
                ) / 2.0;

            } else if (L1 > R2) {

                // nums1 contributed too much to LEFT
                hi = partition1 - 1;

            } else {

                // nums1 contributed too little to LEFT
                lo = partition1 + 1;
            }
        }

        return 0.0;
    }
}