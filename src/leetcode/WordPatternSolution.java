package leetcode;

import java.util.HashMap;

/**
 * Created by yufeijiang on 2/15/16.
 */
public class WordPatternSolution {
    /*

    HASH MAP HAS CONTAINSVALUE METHOD, CAN USE IT TO CHECK IF
    THERE IS VALUE FOR OTHER KEY, IF MAP DOES NOT CONTAIN KEY BUT CONTAIN
    THE VALUE, THEN RETURN FALSE; IF MAO CONTAIN KEY BUT DOES NOT CONTAIN
    THE VALUE (EXISTING VALUE DOES NOT EQUAL TO THE NEW COMING ONE, THEN RETURN FALSE)

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i=0;i<pattern.length();i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                if(map.containsValue(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
            }else {
                if(strs[i].equals(map.get(pattern.charAt(i)))) continue;
                else return false;
            }
        }
        return true;
    }
     */

    public boolean wordPattern(String pattern, String str) {
        if(str==null){
            return false;
        }
        if(str.equals("")){
            return false;
        }
        String[] array=str.split(" ");
        if(pattern.length()!=array.length){
            return false;
        }
        HashMap<Character, String> map=new HashMap();
        HashMap<String, Character> reverseMap=new HashMap();
        for(int i=0;i<pattern.length();i++){
            Character patternChar=pattern.charAt(i);
            if(map.containsKey(patternChar)){
                if(!map.get(patternChar).equals(array[i])){
                    return false;
                }
            }else{
                map.put(pattern.charAt(i),array[i]);
            }
            if(reverseMap.containsKey(array[i])){
                if(!reverseMap.get(array[i]).equals(patternChar)){
                    return false;
                }
            }else{
                reverseMap.put(array[i],patternChar);
            }
        }
        return true;
    }
}
