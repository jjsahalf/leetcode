package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class PaintHouseIISolution {
    public int minCostII(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0){
            return 0;
        }
        int[][] dp=new int[costs.length][costs[0].length];
        for(int j=0;j<costs[0].length;j++){
            dp[0][j]=costs[0][j];
        }
        for(int i=1; i<costs.length; i++){
            PriorityQueue<Integer> pq=new PriorityQueue();
            for(int j=0;j<costs[0].length;j++){
                pq.add(dp[i-1][j]);
            }
            for(int j=0;j<costs[0].length;j++){
                if(dp[i-1][j]!=pq.peek()){
                    dp[i][j]=costs[i][j]+pq.peek();
                }else{
                    int small=pq.poll();
                    dp[i][j]=costs[i][j]+pq.peek();
                    pq.offer(small);
                }
            }
        }
        Arrays.sort(dp[dp.length-1]);
        return dp[dp.length-1][0];
    }
}
