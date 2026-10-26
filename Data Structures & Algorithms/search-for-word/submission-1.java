class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (searchChar(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean searchChar(char[][] board, int row, int col, String word, int idx) {
        if (idx == word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
            || idx > word.length()) {
            return false;
        }

        if (board[row][col] != word.charAt(idx))
            return false;

        char temp = board[row][col];
        board[row][col] = '#';

        // explore in 4 directions
        boolean found = searchChar(board, row - 1, col, word, idx + 1)
            || searchChar(board, row + 1, col, word, idx + 1)
            || searchChar(board, row, col - 1, word, idx + 1)
            || searchChar(board, row, col + 1, word, idx + 1);

        board[row][col] = temp;

        return found;
    }
}
