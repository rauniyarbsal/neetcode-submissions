class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length, cols = board[0].length;

        for(int row = 0; row < rows; row++){
            // left first col
            if(board[row][0] == 'O') dfs(board, row, 0);

            if(board[row][cols-1] == 'O') dfs(board, row, cols-1); // last col

        }

        for(int col=0; col < cols; col++){
            //first row fixed, col iterate
            if(board[0][col] == 'O') dfs(board, 0, col);

            // last row fixed, col iterate
            if(board[rows-1][col] == 'O') dfs(board, rows-1, col);
        }

        // traverse once again in the board, and safely convert # back to O and current O to X
        for(int row=0; row < board.length; row++){
            for(int col=0; col < board[0].length; col++){

                if(board[row][col] == 'O'){
                    board[row][col] = 'X';

                }

                if(board[row][col] == '#'){
                    board[row][col] = 'O';

                }

            }

        }


    }

    public void dfs(char [][]board, int i, int j){

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O'){
            return;

        }

        board[i][j] = '#'; // temporarily marked as #

        // explore all possible 4 directions
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}

/*
So your complete thought process is:
1. Find every 'O' on the four borders.

2. From each border O:
      DFS in 4 directions
      mark every connected O as '#'

3. Traverse entire board:
      O → X    // wasn't border-connected → surrounded
      # → O    // was border-connected → restore it

And the reason # is useful is that it simultaneously means:
“I've visited this O, and I've proven that it belongs to a region connected to the border, so protect it from being captured.”
*/
