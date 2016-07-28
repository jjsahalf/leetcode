package leetcode;

import java.util.Set;

/**
 * Created by yufeijiang on 7/27/16.
 */
public class WordBreak {

    //DP
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || wordDict==null || s.length()==0 || wordDict.size()==0){
            return false;
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1; i<=s.length(); i++){
            String tillHere=s.substring(0,i);
            for(String str:wordDict){
                if(tillHere.endsWith(str) && dp[i-str.length()]){
                    dp[i]=true;
                }
            }
        }
        return dp[dp.length-1];
    }


    /*
    DFS execution time exceeds
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s==null || wordDict==null || s.length()==0 || wordDict.size()==0){
            return false;
        }
        if(quickCheck(s, wordDict)){
            return helper(s, wordDict);
        }else{
            return false;
        }

    }
    public boolean helper(String s, Set<String> wordDict){
        if(s.equals("")){
            return true;
        }
        //boolean result=false;
        for(String str:wordDict){
            if(s.startsWith(str)){
                if(helper(s.substring(str.length(), s.length()), wordDict)){
                    return true;
                }
                //result = result || helper(s.substring(str.length(), s.length()), wordDict);
            }
        }
        return false;
    }
     */
}
