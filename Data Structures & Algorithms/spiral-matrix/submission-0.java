class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // 1. traverse first row
            for (int i = colBegin; i <= colEnd; i++) {
                ans.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            // 2. traverse col
            for (int i = rowBegin; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }

            colEnd--;

            // 3. traverse row again
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            // 4. traverse col again
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--  ) {
                    ans.add(matrix[i][colBegin]);
                }
            }

            colBegin++;

            // repeat again
        }

        return ans;
    }
}
