package leetcode;

/**
 * Created by yufeijiang on 11/19/16.
 */
public class RepeatedSubstringPatternSolution {
    public boolean repeatedSubstringPattern(String str) {
        if(str==null || str.length()==0){
            return false;
        }
        for(int i=0;i<str.length()/2;i++){
            if(str.length()%(i+1)!=0){
                continue;
            }
            String pattern=str.substring(0,i+1);
            StringBuilder sb=new StringBuilder();
            sb.append(pattern);
            while(str.startsWith(sb.toString())){
                sb.append(pattern);
                if(str.equals(sb.toString())){
                    return true;
                }
            }
        }
        return false;
    }
}
