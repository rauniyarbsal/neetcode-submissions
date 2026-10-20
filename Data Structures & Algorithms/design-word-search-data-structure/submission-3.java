class WordDictionary {
    
    TrieNode root;

    static class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;

        }

    }

    public WordDictionary() {
        root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char ch: word.toCharArray()){
            int idx = ch - 'a';

            //create path if children doesn't exist
            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode();

            }

             curr = curr.children[idx];
        }

        curr.isEnd = true; // complete word ends here

    }

    public boolean search(String word) {
        return dfs(word, 0, root);

    }

    public boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()){
            return node.isEnd;

        }

        char ch = word.charAt(index);

        if(ch == '.'){
            for(TrieNode child: node.children){
                if(child != null){
                    if(dfs(word, index + 1, child)){
                        return true;

                    }
                }
            }

            return false;
        }

        int idx = ch - 'a';

        if(node.children[idx] == null) return false;

        return dfs(word, index + 1, node.children[idx]);


    }
}
