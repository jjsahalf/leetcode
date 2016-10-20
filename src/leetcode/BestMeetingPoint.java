package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 10/13/16.
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        List<Integer> rowList=new ArrayList();
        List<Integer> colList=new ArrayList();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    rowList.add(i);
                }
            }
        }
        for(int j=0; j<grid[0].length;j++){
            for(int i=0; i<grid.length;i++){
                if(grid[i][j]==1){
                    colList.add(j);
                }
            }
        }
        return minDistance(rowList)+minDistance(colList);
    }
    public int minDistance(List<Integer> list){
        int i=0;
        int j=list.size()-1;
        int sum=0;
        while(i<j){
            sum+=list.get(j)-list.get(i);
            i++;
            j--;
        }
        return sum;
    }

}
