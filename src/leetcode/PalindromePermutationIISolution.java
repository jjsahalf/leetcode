package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yufeijiang on 9/14/16.
 */
public class PalindromePermutationIISolution {
    private Map<Character, Integer> map=new HashMap();
    private char oddKey;
    private int oddCounter=0;

    public List<String> generatePalindromes(String s) {
        List<String> list=new ArrayList();
        if(s==null || s.length()==0){
            return list;
        }
        char oddKey;
        if(isPalindrome(s)){
            StringBuffer sb=new StringBuffer();
            for(Map.Entry<Character, Integer> entry:map.entrySet()){
                char key=entry.getKey();
                int value=entry.getValue();
                if(value%2==1){
                    oddKey=key;
                }
                int times=value/2;
                for(int i=0;i<times;i++){
                    sb.append(key);
                }
            }
            String base=sb.toString();
            sb=new StringBuffer();
            int[] visited=new int[base.length()];
            helper(list,sb,base,visited);
            return list;
        }else{
            return list;
        }

    }

    public void helper(List<String> list, StringBuffer sb, String base, int[] visited){
        if(sb.length()==base.length()){
            int lastIndex=sb.length()-1;
            StringBuffer res=new StringBuffer(sb);
            if(oddCounter==1){
                res.append(oddKey);
            }
            for(int i=lastIndex;i>=0;i--){
                res.append(sb.charAt(i));
            }
            list.add(res.toString());
        }else{
            for(int i=0;i<base.length();i++){
                if(visited[i]==1){
                    continue;
                }
                if(i!=0 && base.charAt(i)==base.charAt(i-1) && visited[i-1]==0){
                    continue;
                }
                sb.append(base.charAt(i));
                visited[i]=1;
                helper(list,sb,base,visited);
                visited[i]=0;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(map.containsKey(curr)){
                int counter=map.get(curr);
                counter++;
                map.put(curr,counter);
            }else{
                map.put(curr,1);
            }
        }
        oddCounter=0;
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            int value=entry.getValue();
            if(value%2==1){
                oddCounter++;
                oddKey=entry.getKey();
            }
            if(oddCounter>1){
                return false;
            }
        }
        return true;
    }
}
