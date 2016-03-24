package leetcode;

import java.util.*;

/**
 * Created by yufeijiang on 3/24/16.
 */
public class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList();
        if(strs==null || strs.length==0){
            return result;
        }

        Map<List<Character>, List<String>> map=new HashMap();
        Arrays.sort(strs);


        for(int i=0; i<strs.length;i++){
            String item=strs[i];
            List<Character> charList=new ArrayList();
            for(int j=0;j<item.length();j++){
                charList.add(item.charAt(j));
            }
            Collections.sort(charList);
            if(map.containsKey(charList)){
                List<String> updateList=map.get(charList);
                updateList.add(item);
                map.put(charList, updateList);
            }else{
                List<String> updateList=new ArrayList();
                updateList.add(item);
                map.put(charList, updateList);
            }
        }

        Set<Map.Entry<List<Character>, List<String> >> entrySet=map.entrySet();
        for(Map.Entry<List<Character>, List<String>> entry: entrySet){
            result.add(entry.getValue());
        }

        return result;
    }
}
