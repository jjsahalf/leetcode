package leetcode;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class IntegerBreakSolution {

    /*
    还有更简单的办法:
        int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

        int integerBreak(int n) {
        vector<int> dp{0, 0, 1, 2, 4, 6, 9};
        for (int i = 7; i <= n; ++i) {
            dp.push_back(3 * dp[i - 3]);
        }
        return dp[n];
    }
     */


    public int integerBreak(int n) {
        if(n<2 || n>58){
            return -1;
        }
        int[] dp=new int[n+1];
        dp[0]=-1;
        dp[1]=-1;
        dp[2]=1;
        for(int i=0;i<=n;i++){
            int left=1;
            int right=i-1;
            int max=Integer.MIN_VALUE;
            while(left<=right){
                int curr=Math.max(dp[left], left)*Math.max(dp[right],right);
                max=Math.max(max,curr);
                left++;
                right--;
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
