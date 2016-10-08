package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yufeijiang on 10/7/16.
 */
public class DungeonGameSolution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0){
            return 0;
        }
        int[][] dp=new int[dungeon.length][dungeon[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[dungeon.length-1][dungeon[0].length-1]=dungeon[dungeon.length-1][dungeon[0].length-1]>=0?1:1-dungeon[dungeon.length-1][dungeon[0].length-1];
        Queue<int[]> queue=new LinkedList();
        int[] firstPoint={dungeon.length-1, dungeon[0].length-1};
        for(int i=(dp.length-1+dp[0].length-1); i>=0;i--){
            for(int j=0;j<=i;j++){
                if( (i-j)>=0 && (i-j)<dp.length && j>=0 && j<dp[0].length){
                    int row=i-j;
                    int column=j;
                    if(row-1>=0){
                        dp[row-1][column]=Math.min(dp[row-1][column], dp[row][column]-dungeon[row-1][column]);
                        if(dp[row-1][column]<=0){
                            dp[row-1][column]=1;
                        }
                    }
                    if(column-1>=0){
                        dp[row][column-1]=Math.min(dp[row][column-1], dp[row][column]-dungeon[row][column-1]);
                        if(dp[row][column-1]<=0){
                            dp[row][column-1]=1;
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }
}
