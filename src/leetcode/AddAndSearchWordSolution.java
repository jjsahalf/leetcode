package leetcode;

/**
 * Created by yufeijiang on 8/18/16.
 */
public class AddAndSearchWordSolution {
//其他解法在leetcode上都超时


    // Adds a word into the data structure.
    Trier root = new Trier();
    public void addWord(String word) {
        Trier pointer = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (pointer.children[c-'a'] == null) {
                pointer.children[c-'a'] = new Trier();
                pointer = pointer.children[c-'a'];
            } else {
                pointer = pointer.children[c-'a'];
            }
        }
        pointer.flag = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        Trier pointer = root;
        return helper(word,0,pointer);
    }
    private boolean helper(String word, int start, Trier cur) {
        if (start == word.length()) {
            if (cur.flag) {
                return true;
            } else {
                return false;
            }
        }
        char c = word.charAt(start);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (helper(word,start+1,cur.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            if (cur.children[c-'a'] == null) {
                return false;
            } else {
                return helper(word,start+1,cur.children[c-'a']);
            }
        }
        return false;
    }
    class Trier {
        Trier[] children;
        char c;
        boolean flag;
        public Trier() {
            children = new Trier[26];
            flag = false;
        }
    }
}
