package leetcode;

/**
 * Created by yufeijiang on 8/17/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null || word.length()==0){
            return;
        }
        TrieNode temp=root;
        for(int i=0; i<word.length();i++){
            char curr = word.charAt(i);
            if(temp.tracker.containsKey(curr)){
                temp=temp.tracker.get(curr);
            }else{
                TrieNode node=new TrieNode();
                node.c=curr;
                temp.tracker.put(curr, node);
                temp=node;
                temp.isLeaf=false;
            }
            if(i==word.length()-1){
                temp.isLeaf=true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word==null || word.length()==0){
            return false;
        }
        TrieNode temp=root;
        for(int i=0; i<word.length();i++){
            char curr=word.charAt(i);
            if(temp.tracker.containsKey(curr)){
                temp=temp.tracker.get(curr);
            }else{
                return false;
            }
        }
        return temp.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix==null || prefix.length()==0){
            return false;
        }
        TrieNode temp=root;
        for(int i=0; i<prefix.length();i++){
            char curr=prefix.charAt(i);
            if(temp.tracker.containsKey(curr)){
                temp=temp.tracker.get(curr);
            }else{
                return false;
            }
        }
        return true;
    }

    private TrieNode searchNode(String word) {
        if (word == null || word.length() == 0)
            return null;
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (!temp.tracker.containsKey(curr)) {
                return null;
            }else {
                temp = temp.tracker.get(curr);
            }
        }
        return temp;
    }
}
