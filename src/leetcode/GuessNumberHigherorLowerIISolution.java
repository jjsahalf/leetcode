package leetcode;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class GuessNumberHigherorLowerIISolution {
    public int getMoneyAmount(int n) {
        if(n<1){
            return -1;
        }
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<=n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int currExpense=k;
                    if(k-1>i && k+1<j){
                        currExpense=k+Math.max(dp[i][k-1],dp[k+1][j]);
                    }else if(k-1>i){
                        currExpense=k+dp[i][k-1];
                    }else if(k+1<j){
                        currExpense=k+dp[k+1][j];
                    }
                    min=Math.min(min,currExpense);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n];
    }
}
