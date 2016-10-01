package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by yufeijiang on 9/30/16.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res=new ArrayList();
        if(s==null || wordDict==null || s.length()==0 || wordDict.size()==0){
            return res;
        }
        StringBuffer sb=new StringBuffer();
        boolean[] mem=new boolean[s.length()];
        for(int i=0;i<mem.length;i++){
            mem[i]=true;
        }
        int originalLength=s.length();
        helper(s, wordDict, res, sb, mem, originalLength);
        return res;
    }
    public void helper(String s, Set<String> wordDict, List<String> res, StringBuffer sb, boolean[] mem, int originalLength){
        if(s.equals("")){
            String resStr=sb.toString();
            resStr=resStr.substring(0,resStr.length()-1);
            res.add(resStr);
        }
        for(String str:wordDict){
            if(s.startsWith(str) && mem[originalLength-s.length()]){
                sb.append(str);
                sb.append(" ");
                int prevSize=res.size();
                helper(s.substring(str.length()), wordDict, res, sb, mem, originalLength);
                int afterSize=res.size();
                if(prevSize==afterSize){
                    mem[originalLength-s.substring(str.length()).length()]=false;
                }
                sb.delete(sb.length()-str.length()-1, sb.length());
            }
        }
    }
}

