package leetcode;

/**
 * Created by yufeijiang on 10/10/16.
 */
public class RegularExpressionMatchingSolution {
    //dfs solution
    public boolean isMatch(String s, String p) {
        if(p.length()==0){
            return s.length()==0;
        }
        if(p.length()==1){
            return s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.' );
        }
        if(p.charAt(1)!='*'){
            if(s.length()!=0 && ( s.charAt(0) == p.charAt(0) || p.charAt(0)=='.')    ){
                return isMatch(s.substring(1), p.substring(1));
            }else{
                return false;
            }
        }
        if(p.charAt(1)=='*'){
            if(s.length()==0){
                return isMatch(s, p.substring(2));
            }else{
                while(s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0) == '.')  ){
                    if(isMatch(s, p.substring(2))){
                        return true;
                    }else{
                        s=s.substring(1);
                    }
                }
                return isMatch(s,p.substring(2));
            }
        }
        return false;
    }

    //dp solution
    public boolean isMatchII(String s, String p) {
        if(s==null || p==null){
            return false;
        }
        if(s.equals(p)){
            return true;
        }
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=0;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(i==0 && j==0){
                    continue;
                }
                char pChar=p.charAt(j-1);
                if(pChar!='*'){
                    dp[i][j]=i>0 && j>0 && dp[i-1][j-1] && (s.charAt(i-1) == pChar || pChar=='.' );
                }else{
                    dp[i][j]=(j>=2 && dp[i][j-2]) || (i>=1 && j>=2 && dp[i-1][j]  && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) =='.' )  );
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
