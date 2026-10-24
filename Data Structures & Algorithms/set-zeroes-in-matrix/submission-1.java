class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;

        for(int row = 0; row < matrix.length; row++){ // check first col
            if(matrix[row][0] == 0) firstCol = true;

        }

        for(int col = 0; col < matrix[0].length; col++){ // check first row
            if(matrix[0][col] == 0) firstRow = true;

        }

        //explore inner matrix
        for(int row = 1; row < matrix.length; row++){
            for(int col = 1; col < matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;

                }

            }
        }

        for(int row = 1; row < matrix.length; row++){
            for(int col = 1; col < matrix[0].length; col++){
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                    
                }

            }
        }

        // check if first row is zero, if yes mark each cell in first row zero
        if(firstRow){
            for(int col = 0; col < matrix[0].length; col++){
                matrix[0][col] = 0;

            }
        }

        //check if first col is zero, if yes mark each cell in first col zero
        if(firstCol){
            for(int row = 0; row < matrix.length; row++){
                matrix[row][0] = 0;

            }

        }
        
    }
}
