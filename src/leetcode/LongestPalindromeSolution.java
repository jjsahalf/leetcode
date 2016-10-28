package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 10/28/16.
 */
public class LongestPalindromeSolution {
    public int longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        System.out.println(s.length());
        Map<Character, Integer> map=new HashMap();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(!map.containsKey(curr)){
                map.put(curr,1);
            }else{
                map.put(curr, map.get(curr)+1);
            }
        }
        int odd=0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()%2==1){
                odd++;
            }
        }
        if(odd==0){
            return s.length();
        }else{
            return s.length()-(odd-1);
        }
    }
}
