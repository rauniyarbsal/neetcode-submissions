class Solution {
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            // Step 1:
            // Get rightmost bit of n
            int bit = n & 1;

            // Step 2:
            // Make room in result
            result = result << 1;

            // Step 3:
            // Put extracted bit into result
            result = result | bit;

            // Step 4:
            // Move n right so next bit becomes rightmost
            n = n >>> 1;
        }

        return result;
    }
}

/* Time: O(1), Space: O(1), because we're always processing exactly 32 bits regardless of the input value.*/