package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yufeijiang on 9/13/16.
 */
class Pos{
    public int row;
    public int column;
    public int distance;
    public Pos(int r, int c, int d){
        row=r;
        column=c;
        distance=d;
    }
}

public class WallsandGatesSolution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0].length==0){
            return;
        }
        Queue<Pos> queue=new LinkedList();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    queue.add(new Pos(i,j,0));
                }
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pos pos=queue.poll();
                int row=pos.row;
                int column=pos.column;
                int distance=pos.distance;
                explore(queue, row+1,column,distance,rooms);
                explore(queue, row-1,column,distance,rooms);
                explore(queue, row,column+1,distance,rooms);
                explore(queue, row,column-1,distance,rooms);
            }
        }
    }
    public void explore(Queue<Pos> queue, int row, int column, int distance, int[][] rooms){
        if(row>=0 && row<rooms.length && column>=0 && column<rooms[0].length && rooms[row][column]!=-1){
            int prev=rooms[row][column];
            rooms[row][column]=Math.min(rooms[row][column],distance+1);
            if(rooms[row][column]!=prev){
                queue.offer(new Pos(row,column,distance+1));
            }
        }
    }
}
