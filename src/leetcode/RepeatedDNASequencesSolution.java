package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yufeijiang on 8/25/16.
 */
public class RepeatedDNASequencesSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list=new ArrayList();
        Map<String, Integer> map=new HashMap();
        if(s==null || s.length()<=10){
            return list;
        }
        int start=0;
        int end=10;
        while(end<=s.length()){
            String str=s.substring(start,end);
            if(map.containsKey(str)){
                int times=map.get(str);
                times++;
                map.put(str,times);
                if(times==2){
                    list.add(str);
                }
            }else{
                map.put(str,1);
            }
            start++;
            end++;
        }
        return list;
    }
}
