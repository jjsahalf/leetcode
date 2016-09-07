package leetcode;

/**
 * Created by yufeijiang on 9/6/16.
 */
public class PerfectSquaresSolution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        int root=1;
        int square=root*root;
        dp[0]=1;
        for(int i=1; i<=n;i++){
            if(i==square){
                root++;
                square=root*root;
                dp[i]=1;
            }else{
                int left=1;
                int right=i-1;
                int min=Integer.MAX_VALUE;
                while(left<=right){
                    int curr=dp[left]+dp[right];
                    min=Math.min(min, curr);
                    left++;
                    right--;
                }
                dp[i]=min;
            }
        }
        return dp[n];
    }
}
