package leetcode;

/**
 * Created by yufeijiang on 5/10/16.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null){
            return 0;
        }


        int column=grid[0].length;
        int row=grid.length;

        int[][] dp=new int[row][column];
        dp[0][0]=grid[0][0];

        for(int i=1;i<row; i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int j=1;j<column;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<column;j++){
                if(dp[i][j-1]<dp[i-1][j]){
                    dp[i][j]=grid[i][j]+dp[i][j-1];
                }else{
                    dp[i][j]=grid[i][j]+dp[i-1][j];
                }
            }
        }

        return dp[row-1][column-1];



    }
}
