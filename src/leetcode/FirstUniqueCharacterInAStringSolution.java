package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 10/19/16.
 */
public class FirstUniqueCharacterInAStringSolution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0){
            return -1;
        }
        Map<Character, Integer> map=new HashMap();
        for(int i=0;i<s.length();i++){
            Character curr=s.charAt(i);
            if(map.containsKey(curr)){
                map.put(curr, s.length());
            }else{
                map.put(curr, i);
            }
        }
        int min=s.length();
        for(Map.Entry<Character, Integer> entry:map.entrySet()){
            int value=entry.getValue();
            min=Math.min(min, value);
        }
        if(min==s.length()){
            return -1;
        }
        return min;
    }
}
