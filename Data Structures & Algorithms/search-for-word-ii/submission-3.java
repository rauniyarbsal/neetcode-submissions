class Solution {

    TrieNode root = new TrieNode();

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];

        // null means no complete word ends here
        String word = null;
    }

    public void insert(String[] words) {

        for (String word : words) {

            TrieNode curr = root;

            for (char ch : word.toCharArray()) {

                int idx = ch - 'a';

                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }

                curr = curr.children[idx];
            }

            // Store complete word at ending node
            curr.word = word;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();

        // 1. Build Trie
        insert(words);

        // 2. Try DFS from every board cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                searchChar(board, i, j, root, ans);
            }
        }

        return ans;
    }


    public void searchChar(
        char[][] board,
        int row,
        int col,
        TrieNode curr,
        List<String> ans
    ) {

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        // Already visited
        if (ch == '#') {
            return;
        }

        int idx = ch - 'a';

        // No word has this prefix
        if (curr.children[idx] == null) {
            return;
        }

        // Move down the Trie
        TrieNode next = curr.children[idx];

        // Found a complete word
        if (next.word != null) {

            ans.add(next.word);

            // Prevent duplicate addition
            next.word = null;
        }

        // Mark board cell visited
        board[row][col] = '#';

        // Explore 4 directions
        searchChar(board, row - 1, col, next, ans);
        searchChar(board, row + 1, col, next, ans);
        searchChar(board, row, col - 1, next, ans);
        searchChar(board, row, col + 1, next, ans);

        // Backtrack
        board[row][col] = ch;
    }
}