package leetcode;

/**
 * Created by yufeijiang on 8/26/15.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null){
            return null;
        }
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }

        String prefix=strs[0];
        for(int i=0;i<strs.length;i++){
            if(strs[i]==null){
                return null;
            }
            if(strs[i].equals("")){
                return "";
            }
            int j=0;
            while(j<prefix.length()&&j<strs[i].length()){
                if(prefix.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            if(j==0){
                return "";
            }
            if(j==1){
                StringBuffer sb=new StringBuffer();
                sb.append(strs[i].charAt(0));
                prefix=sb.toString();
            }
            if(j>1){
                prefix=prefix.substring(0,j);
            }
        }
        return prefix;

    }
}
