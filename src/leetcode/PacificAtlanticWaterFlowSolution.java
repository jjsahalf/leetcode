package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yufeijiang on 11/6/16.
 */
public class PacificAtlanticWaterFlowSolution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list=new ArrayList();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return list;
        }
        boolean[][] pacificVisited=new boolean[matrix.length][matrix[0].length];
        boolean[][] atlanticVisited=new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++){
            dfs(pacificVisited, 0, i, matrix);
            dfs(atlanticVisited, matrix.length-1, i, matrix);
        }
        for(int i=0;i<matrix.length;i++){
            dfs(pacificVisited, i,0, matrix);
            dfs(atlanticVisited, i, matrix[0].length-1, matrix);
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    int[] pair={i, j};
                    list.add(pair);
                }
            }
        }
        return list;
    }
    public void dfs(boolean visited[][], int row, int col, int[][] matrix){
        if(visited[row][col]){
            return;
        }
        visited[row][col]=true;
        int[] dRow={1,-1,0,0};
        int[] dCol={0,0,1,-1};
        int currHeight=matrix[row][col];
        for(int i=0; i<4;i++){
            int nextRow=row+dRow[i];
            int nextCol=col+dCol[i];
            if(nextRow>=0 && nextRow<matrix.length && nextCol>=0 && nextCol<matrix[0].length && matrix[nextRow][nextCol]>=
                    currHeight){
                dfs(visited, nextRow,nextCol,matrix);
            }
        }
    }
}
