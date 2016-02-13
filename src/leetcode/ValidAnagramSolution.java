package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 2/13/16.
 */
public class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        int sLength=s.length();
        int tLength=t.length();
        if(sLength!=tLength){
            return false;
        }

        Map<Character, Integer> map=new HashMap();

        for(int i=0;i<sLength;i++){
            Character each=s.charAt(i);
            if(map.containsKey(each)){
                map.put(each,map.get(each)+1);
            }else{
                map.put(each,1);
            }
        }

        for(int j=0;j<tLength;j++){
            Character tEach=t.charAt(j);
            if(map.containsKey(tEach)){
                if(map.get(tEach)==0){
                    return false;
                }else{
                    map.put(tEach,map.get(tEach)-1);
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
