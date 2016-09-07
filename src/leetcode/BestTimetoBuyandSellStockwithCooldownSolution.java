package leetcode;

/**
 * Created by yufeijiang on 9/6/16.
 */
public class BestTimetoBuyandSellStockwithCooldownSolution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int[] buy=new int[prices.length+1];
        int[] sell=new int[prices.length+1];
        buy[0]=0;
        sell[0]=0;
        buy[1]=0-prices[0];
        sell[1]=0;
        for(int i=2;i<sell.length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i-1]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i-1]);
        }
        return sell[sell.length-1];
    }
}
