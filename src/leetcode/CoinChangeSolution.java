package leetcode;

/**
 * Created by yufeijiang on 9/6/16.
 */
public class CoinChangeSolution {

    /*
    public int coinChange(int[] coins, int amount) {
    if(amount==0) return 0;

    int[] dp = new int [amount+1];
    dp[0]=0; // do not need any coin to get 0 amount
    for(int i=1;i<=amount; i++)
        dp[i]= Integer.MAX_VALUE;

    for(int i=0; i<=amount; i++){
        for(int coin: coins){
            if(i+coin <=amount){
                if(dp[i]==Integer.MAX_VALUE){
                    dp[i+coin] = dp[i+coin];
                }else{
                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                }
            }
        }
    }

    if(dp[amount] >= Integer.MAX_VALUE)
        return -1;

    return dp[amount];
}

     */

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1; i<=amount;i++){
            dp[i]=-1;
        }
        for(int coin:coins){
            if(coin<=amount){
                dp[coin]=1;
            }
        }
        for(int i=1; i<=amount;i++){
            if(dp[i]==1){
                continue;
            }else{
                int min=Integer.MAX_VALUE;
                for(int coin:coins){
                    if(i>=coin){
                        if(dp[i-coin]!=-1){
                            min=Math.min(min,dp[i-coin]+1);
                        }
                    }
                }
                if(min==Integer.MAX_VALUE){
                    dp[i]=-1;
                }else{
                    dp[i]=min;
                }
            }
        }
        return dp[amount];
    }
}
