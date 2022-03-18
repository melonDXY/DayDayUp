package codes.Trie208;

public class Trie {
    
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
                
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        if(node != null && node.isEnd) {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        if(node != null) {
            return true;
        }
        return false;
    }

    public Trie searchPrefix(String prefix) {
        Trie node = this;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
        
    }

    
}
