package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 10/12/16.
 */
public class LongestSubstringWithAtMostKDistinctCharactersSolution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.length()==0){
            return 0;
        }
        if(k==0){
            return 0;
        }
        Map<Character, Integer> map=new HashMap();
        int p1=0;
        int p2=0;
        int counter=0;
        int max=0;
        while(p2<s.length()){
            char curr=s.charAt(p2);
            if(map.containsKey(curr)){
                int value=map.get(curr);
                if(value==0){
                    counter++;
                }
                value++;
                map.put(curr, value);
            }else{
                counter++;
                map.put(curr,1);
            }
            if(counter<=k){
                max=Math.max(max, p2-p1+1);
            }else{
                while(counter>k && p1<s.length()){
                    char left=s.charAt(p1);
                    int value=map.get(left);
                    value--;
                    if(value==0){
                        counter--;
                    }
                    map.put(left, value);
                    p1++;
                }
            }
            p2++;
        }
        return max;
    }
}
