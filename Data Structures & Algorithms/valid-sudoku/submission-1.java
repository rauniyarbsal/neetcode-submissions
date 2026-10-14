class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0; i < 9; i++){ // row
            Set<Character> hs = new HashSet<>();
            for(int j=0; j < 9; j++){
                if(board[i][j] == '.') continue;

                if(!hs.add(board[i][j])) return false;

            }
        } 

        

        for(int i=0; i < 9; i++){ // col
            Set<Character> hs = new HashSet<>();
            for(int j=0; j < 9; j++){
                if(board[j][i] == '.') continue;

                if(!hs.add(board[j][i])) return false;

            }
        } 

        // now for all 3 * 3 boxes
        for(int i=0;i < 9; i += 3){
            for(int j=0; j < 9; j += 3){
                Set<Character> hs = new HashSet<>();

                for(int k= i; k < i + 3; k++){
                    for(int l = j; l < j + 3 ; l++){
                        if(board[k][l] == '.') continue;

                        if(!hs.add(board[k][l])) return false;
                    }
                }
            }

        }

        return true;
    }
}
