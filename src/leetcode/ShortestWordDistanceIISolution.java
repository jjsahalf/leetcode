package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class ShortestWordDistanceIISolution {
    private Map<String, List<Integer>> map;

    public ShortestWordDistanceIISolution(String[] words) {
        map=new HashMap();
        for(int i=0; i<words.length; i++){
            String s=words[i];
            if(map.containsKey(s)){
                List<Integer> list=map.get(s);
                list.add(i);
                map.put(s,list);
            }else{
                List<Integer> list=new ArrayList();
                list.add(i);
                map.put(s,list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> pos1List=map.get(word1);
        List<Integer> pos2List=map.get(word2);
        int minDistance=Integer.MAX_VALUE;
        for(Integer i:pos1List){
            for(Integer j:pos2List){
                minDistance=Math.min(Math.abs(i-j),minDistance);
            }
        }
        return minDistance;
    }
}
