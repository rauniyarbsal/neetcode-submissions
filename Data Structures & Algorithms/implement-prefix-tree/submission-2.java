class PrefixTree {
    TrieNode root; // O(N * L)

    static class TrieNode{
        TrieNode []children = new TrieNode[26];
        boolean isEnd = false;

    }

    public PrefixTree() {
        root = new TrieNode();
         
    }

    public void insert(String word) { // O(L)
        TrieNode curr = root;

        for(char ch: word.toCharArray()){
            int idx = ch - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode();

            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;

    }

    public boolean search(String word) { // O(L)
        TrieNode curr = root;

        for(char ch: word.toCharArray()){
            int idx = ch - 'a';

            if(curr.children[idx] == null) return false;

            curr = curr.children[idx];
        }

        return curr.isEnd;

    }

    public boolean startsWith(String prefix) { // O(L)
        TrieNode curr = root;

        for(char ch: prefix.toCharArray()){
            int idx = ch - 'a';

            if(curr.children[idx] == null) return false;

            curr = curr.children[idx];
        }

        return true;
    }   
}
