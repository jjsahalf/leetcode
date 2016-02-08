package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yufeijiang on 2/8/16.
 */
public class IsomorphicStringsSolution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null && t==null){
            return true;
        }
        if(s.equals("") && t.equals("")){
            return true;
        }

        Map<Character,Character> sMap=new HashMap();
        Map<Character,Character> tMap=new HashMap();
        for(int i=0;i<s.length();i++){
            Character sChar=s.charAt(i);
            Character tChar=t.charAt(i);
            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar)==tChar){
                    continue;
                }else{
                    return false;
                }
            }else{
                sMap.put(sChar,tChar);
            }

            if(tMap.containsKey(tChar)){
                if(!(tMap.get(tChar)==sChar)){
                    return false;
                }
            }else{
                tMap.put(tChar,sChar);
            }



        }

        return true;



    }
}
