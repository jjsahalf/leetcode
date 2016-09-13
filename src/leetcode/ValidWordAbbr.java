package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yufeijiang on 9/13/16.
 */
public class ValidWordAbbr {

    private Map<String, Integer> map;
    private Set<String> set;

    public ValidWordAbbr(String[] dictionary) {
        set=new HashSet();
        for(String s:dictionary){
            set.add(s);
        }

        map=new HashMap();
        for(String str:set){
            String abb=getAbb(str);
            if(map.containsKey(abb)){
                int counter=map.get(abb);
                counter++;
                map.put(abb,counter);
            }else{
                map.put(abb,1);
            }
        }
    }

    public boolean isUnique(String word) {
        if(set.contains(word)){
            String abb=getAbb(word);
            int counter=map.get(abb);
            if(counter==1){
                return true;
            }else{
                return false;
            }
        }else{
            String abb=getAbb(word);
            if(map.containsKey(abb)){
                return false;
            }else{
                return true;
            }
        }
    }
    public String getAbb(String str){
        if(str.length()<=2){
            return str;
        }else{
            StringBuffer sb=new StringBuffer();
            sb.append(str.charAt(0));
            Integer number=str.length()-2;
            sb.append(number.toString());
            sb.append(str.charAt(str.length()-1));
            return sb.toString();
        }
    }
}
