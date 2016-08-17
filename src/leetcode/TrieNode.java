package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 8/17/16.
 */
public class TrieNode {
    // Initialize your data structure here.
    public char c;
    public boolean isLeaf;
    public Map<Character, TrieNode> tracker= new HashMap<Character, TrieNode>();
    public TrieNode() {

    }



}
