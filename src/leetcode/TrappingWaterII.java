package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yufeijiang on 10/26/16.
 */

class WaterCell{
    public int row;
    public int col;
    public int height;
    public WaterCell(int row, int col, int height){
        this.row=row;
        this.col=col;
        this.height=height;
    }
}



public class TrappingWaterII {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length==0 ||heightMap[0].length==0){
            return 0;
        }
        int rowNum=heightMap.length;
        int colNum=heightMap[0].length;
        boolean[][] visited=new boolean[rowNum][colNum];
        PriorityQueue<WaterCell> pq=new PriorityQueue(new Comparator<WaterCell>(){
            public int compare(WaterCell c1, WaterCell c2){
                return c1.height-c2.height;
            }
        });
        for(int i=0; i<heightMap.length;i++){
            pq.offer(new WaterCell(i,0,heightMap[i][0]));
            pq.offer(new WaterCell(i,colNum-1,heightMap[i][colNum-1]));
            visited[i][0]=true;
            visited[i][colNum-1]=true;
        }
        for(int j=1; j<heightMap[0].length-1;j++){
            pq.offer(new WaterCell(0,j,heightMap[0][j]));
            pq.offer(new WaterCell(rowNum-1,j,heightMap[rowNum-1][j]));
            visited[0][j]=true;
            visited[rowNum-1][j]=true;
        }
        int sum=0;
        while(!pq.isEmpty()){
            WaterCell curr=pq.poll();
            int[] dx={1,-1,0,0};
            int[] dy={0,0,1,-1};
            for(int i=0;i<4;i++){
                int nextRow=curr.row+dy[i];
                int nextCol=curr.col+dx[i];
                if(nextRow>=0 && nextRow<rowNum && nextCol>=0 && nextCol<colNum && !visited[nextRow][nextCol]){
                    visited[nextRow][nextCol]=true;
                    if(curr.height>=heightMap[nextRow][nextCol]){
                        sum+=curr.height-heightMap[nextRow][nextCol];
                    }
                    pq.add(new WaterCell(nextRow, nextCol, Math.max(heightMap[nextRow][nextCol], curr.height)));
                }
            }
        }
        return sum;
    }
}
