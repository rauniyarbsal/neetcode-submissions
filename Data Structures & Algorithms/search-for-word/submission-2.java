class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean findWord(char[][] board, int row, int col, String word, int idx) {
        if(idx == word.length()) return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        if (board[row][col] != word.charAt(idx))
            return false;

        char original = board[row][col];
        board[row][col]  = '#'; // mark it as visited temporariliy

        boolean found = findWord(board, row - 1, col, word, idx + 1)
            || findWord(board, row + 1, col, word, idx + 1)
            || findWord(board, row, col - 1, word, idx + 1)
            || findWord(board, row, col + 1, word, idx + 1);

        board[row][col]  = original;

        return found;
    }
}
