package leetcode;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class PaintHouseSolution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0){
            return 0;
        }
        for(int i=1;i<costs.length;i++){
            costs[i][0]+=Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][0], costs[i-1][1]);
        }
        int index=costs.length-1;
        return Math.min(Math.min(costs[index][0],costs[index][1]),costs[index][2]);
    }
}
