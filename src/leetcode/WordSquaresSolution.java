package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 11/3/16.
 */
public class WordSquaresSolution {


    class TrieNode{
        public List<String> startsWith;
        public TrieNode[] next;
        public TrieNode(){
            startsWith=new ArrayList();
            next=new TrieNode[26];
        }
    }

    class Trie{
        public TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        public void add(String word){
            TrieNode cur=root;
            for(char c:word.toCharArray()){
                if(cur.next[c-'a']==null){
                    cur.next[c-'a']=new TrieNode();
                }
                cur=cur.next[c-'a'];
                cur.startsWith.add(word);
            }
        }
        public List<String> findAllStringWithThisPrefix(String prefix){
            List<String> list=new ArrayList();
            TrieNode cur=root;
            for(char c:prefix.toCharArray()){
                if(cur.next[c-'a']==null){
                    return list;
                }else{
                    cur=cur.next[c-'a'];
                }
            }
            list.addAll(cur.startsWith);
            return list;
        }



    }



    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res=new ArrayList();
        if(words==null || words.length==0){
            return res;
        }
        int len=words[0].length();
        //if(words.length<len){
        //    return res;
        //}
        //build trie
        Trie trie=new Trie();
        for(String str:words){
            trie.add(str);
        }
        List<String> list=new ArrayList();
        for(String str:words){
            list.add(str);
            dfs(list, res, len, words, trie);
            list.remove(list.size()-1);
        }
        return res;
    }
    public void dfs(List<String> list, List<List<String>> res, int len, String[] words, Trie trie){
        if(list.size()==len){
            res.add(new ArrayList(list));
            return;
        }
        StringBuffer prefix=new StringBuffer();
        int col=list.size();
        for(int i=0;i<list.size();i++){
            prefix.append(list.get(i).charAt(col));
        }
        //System.out.println(prefix.toString());
        List<String> candidates=trie.findAllStringWithThisPrefix(prefix.toString());
        for(String str:candidates){
            list.add(str);
            dfs(list, res, len, words, trie);
            list.remove(list.size()-1);
        }
    }
}



