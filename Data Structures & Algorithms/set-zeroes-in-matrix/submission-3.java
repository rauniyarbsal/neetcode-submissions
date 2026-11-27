class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1.scan first row and col
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }

        // 2. scan through second row and col
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. now scan through each cell and see wherever have zero now with help of marker make
        // entire row and col as 0

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //4. check if firstRow or firstCol is true then make entire row or col as zero
        if(firstRowZero){
            for(int i=0; i < matrix[0].length; i++){
                matrix[0][i] = 0;

            }
        }

        if(firstColZero){
            for(int j=0; j < matrix.length; j++){
                matrix[j][0] = 0;

            }
        }
    }
}
