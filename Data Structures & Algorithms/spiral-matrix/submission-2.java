class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0, colBegin = 0;
        int rowEnd = matrix.length-1, colEnd = matrix[0].length-1;

        List<Integer> ans = new ArrayList<>();

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            // 1. fixed first row, traverse col
            for(int i=colBegin; i <= colEnd; i++){
                ans.add(matrix[rowBegin][i]);

            }

            rowBegin++;

            // 2. fixed lastcol, traverse row
            for(int i=rowBegin; i <= rowEnd; i++){
                ans.add(matrix[i][colEnd]);

            }

            colEnd--;

            // 3. fixed lastrow, traverse col
            if(rowBegin <= rowEnd){
                for(int i=colEnd; i >= colBegin; i--){
                    ans.add(matrix[rowEnd][i]);

                }

            }

            rowEnd--;

            // 4. fixed firstcol, traverse row
            if(colBegin <= colEnd){
                for(int i=rowEnd; i >= rowBegin; i--){
                    ans.add(matrix[i][colBegin]);

                }

            }

            colBegin++;
        }

        return ans;
    }
}
