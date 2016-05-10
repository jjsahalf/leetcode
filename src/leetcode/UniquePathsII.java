package leetcode;

/**
 * Created by yufeijiang on 5/10/16.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null){
            return 0;
        }

        int row=obstacleGrid.length;
        int column=obstacleGrid[0].length;

        if(row==0 || column ==0){
            return 0;
        }

        int[][] dp=new int[row][column];

        boolean reachable=true;
        for(int i=0; i<column;i++){
            if(obstacleGrid[0][i]==1){
                dp[0][i]=0;
                reachable=false;
                continue;
            }
            if(reachable){
                dp[0][i]=1;
            }else{
                dp[0][i]=0;
            }
        }

        reachable=true;

        for(int j=0; j<row;j++){
            if(obstacleGrid[j][0]==1){
                dp[j][0]=0;
                reachable=false;
                continue;
            }
            if(reachable){
                dp[j][0]=1;
            }else{
                dp[j][0]=0;
            }
        }

        for(int i=1;i<row;i++){
            for(int j=1; j<column;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }


        return dp[row-1][column-1];






    }
}
