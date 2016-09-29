package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yufeijiang on 9/28/16.
 */
public class FrogJumpSolution {
    public boolean canCross(int[] stones) {
        if(stones==null || stones.length==0){
            return true;
        }
        int lastPositions=stones[stones.length-1];
        Map<Integer, Integer> map=new HashMap();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i], i);
        }
        boolean[][] dp=new boolean[stones.length][stones.length];
        dp[0][0]=true;
        Set<Integer> set=new HashSet();
        set.add(1);
        for(int i=0;i<stones.length-1;i++){
            for(Integer num: set){
                if(stones[i]+num<=lastPositions){
                    if(map.containsKey(stones[i]+num)){
                        dp[i][map.get(stones[i]+num)]=true;
                    }
                }
            }
            set=new HashSet();
            for(int j=0;j<i+1;j++){
                if(dp[j][i+1]==true){
                    int k=stones[i+1]-stones[j];
                    set.add(k);
                    set.add(k+1);
                    set.add(k-1);
                }
            }
        }
        for(int i=0;i<stones.length;i++){
            if(dp[i][dp.length-1]==true){
                return true;
            }
        }
        return false;
    }
}
