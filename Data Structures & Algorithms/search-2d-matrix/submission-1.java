class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowBegin = 0, colBegin = 0;
        int rowEnd = matrix.length-1, colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            if(target >= matrix[rowBegin][colBegin] && target <= matrix[rowBegin][colEnd]){
                int lo = colBegin , hi = colEnd;
                int flag = 0;

                while(lo <= hi){
                    int mid = lo + (hi - lo)/2;

                    if(matrix[rowBegin][mid] == target){
                        flag = 1;
                        return true;

                    }

                    else if(matrix[rowBegin][mid] < target) lo = mid+1;
                    else hi = mid-1;
                }

                if(flag == 0) return false;

            }else{
                rowBegin++;

            }
        }


        return false;
    }
}
