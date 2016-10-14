package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yufeijiang on 10/13/16.
 */
public class ShortestDistanceFromAllBuildingsSolution {
    class Cell{
        int row;
        int col;
        public Cell(int r, int c){
            this.row=r;
            this.col=c;
        }
    }

    public class Solution {
        public int shortestDistance(int[][] grid) {
            if(grid==null || grid.length==0 || grid[0].length==0){
                return 0;
            }
            int[][] dp=new int[grid.length][grid[0].length];

            int totalBuildings=0;
            for(int i=0; i<grid.length;i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==1){
                        totalBuildings++;
                    }
                }
            }
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if(grid[i][j]==2){
                        dp[i][j]=Integer.MAX_VALUE;
                    }
                    if(grid[i][j]==1){
                        int counter=1;
                        dp[i][j]=Integer.MAX_VALUE;
                        boolean[][] visited=new boolean[grid.length][grid[0].length];
                        Queue<Cell> queue=new LinkedList();
                        queue.offer(new Cell(i,j));
                        visited[i][j]=true;
                        int stepCounter=0;
                        while(!queue.isEmpty()){
                            int size=queue.size();
                            for(int k=0;k<size;k++){
                                Cell cell=queue.poll();
                                int row=cell.row;
                                int col=cell.col;
                                if(row-1>=0 && !visited[row-1][col] ){
                                    visited[row-1][col]=true;
                                    if(grid[row-1][col]==0){
                                        queue.offer(new Cell(row-1,col));
                                    }
                                    if(grid[row-1][col]==1){
                                        counter++;
                                    }
                                }
                                if(row+1<grid.length && !visited[row+1][col]){
                                    visited[row+1][col]=true;
                                    if(grid[row+1][col]==0){
                                        queue.offer(new Cell(row+1, col));
                                    }
                                    if(grid[row+1][col]==1){
                                        counter++;
                                    }
                                }
                                if(col-1>=0 && !visited[row][col-1]){
                                    visited[row][col-1]=true;
                                    if(grid[row][col-1]==0){
                                        queue.offer(new Cell(row, col-1));
                                    }
                                    if(grid[row][col-1]==1){
                                        counter++;
                                    }

                                }
                                if(col+1<grid[0].length && !visited[row][col+1]){
                                    visited[row][col+1]=true;
                                    if(grid[row][col+1]==0){
                                        queue.offer(new Cell(row, col+1));
                                    }
                                    if(grid[row][col+1]==1){
                                        counter++;
                                    }
                                }
                                if(dp[row][col]!=Integer.MAX_VALUE){
                                    dp[row][col]+=stepCounter;
                                }
                            }
                            stepCounter++;
                        }
                        for(int m=0;m<visited.length; m++){
                            for(int n=0; n<visited[0].length; n++){
                                if(grid[m][n]==0 && !visited[m][n]){
                                    dp[m][n]=Integer.MAX_VALUE;
                                }
                            }
                        }
                        if(counter!=totalBuildings || stepCounter==1){
                            return -1;
                        }
                    }
                }
            }
            int min=Integer.MAX_VALUE;
            for(int i=0; i<dp.length; i++){
                for(int j=0; j<dp[0].length; j++){
                    min=Math.min(min, dp[i][j]);
                }
            }
            if(min==Integer.MAX_VALUE || min==0){
                return -1;
            }
            return min;
        }
    }
}
