package leetcode;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class RangeSumQuery2DSolution {



    /*
    更好的方法:
        private int[][] matrix;
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;

        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] -
                            sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] -
               sum[row1][col2 + 1] + sum[row1][col1];
    }
     */

    private int[][] dp;

    public RangeSumQuery2DSolution(int[][] matrix) {
        if(matrix!=null && matrix.length!=0 && matrix[0].length!=0){
            int row=matrix.length;
            int column=matrix[0].length;
            dp=new int[row][column];
            for(int i=0;i<matrix.length;i++){
                for(int j=0; j<matrix[0].length;j++){
                    if(j==0){
                        dp[i][j]=matrix[i][j];
                    }else{
                        dp[i][j]=dp[i][j-1]+matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //if(row1==row2 && col1==col2){
        //    return [row1][col1];
        //}
        int sum=0;
        for(int i=row1;i<=row2;i++){
            int num=0;
            if(col1==0){
                num=0;
            }else{
                num=dp[i][col1-1];
            }
            sum+=(dp[i][col2]-num);
        }
        return sum;
    }
}
