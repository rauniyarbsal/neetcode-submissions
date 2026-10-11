class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> hs = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                if (!hs.add(board[i][j]))
                    return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> hs = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;

                if (!hs.add(board[j][i]))
                    return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> hs = new HashSet<>();

                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] == '.')
                            continue;

                        if (!hs.add(board[m][n]))
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
