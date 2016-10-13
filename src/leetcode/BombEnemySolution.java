package leetcode;

/**
 * Created by yufeijiang on 10/13/16.
 */
public class BombEnemySolution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int rowCounter=0;
        int[] col=new int[grid[0].length];
        int max=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++){
                if(i-1<0 || grid[i-1][j]=='W'){
                    int k=i;
                    int localColCounter=0;
                    while(k<grid.length && grid[k][j]!='W'){
                        if(grid[k][j]=='E'){
                            localColCounter++;
                        }
                        k++;
                    }
                    col[j]=localColCounter;
                }
                if(j-1<0 || grid[i][j-1] =='W' ){
                    int k=j;
                    int localRowCounter=0;
                    while(k<grid[0].length && grid[i][k]!='W' ){
                        if(grid[i][k]=='E'){
                            localRowCounter++;
                        }
                        k++;
                    }
                    rowCounter=localRowCounter;
                }
                if(grid[i][j]=='0'){
                    int kill=rowCounter+col[j];
                    max=Math.max(max, kill);
                }
            }
        }
        return max;
    }
}
