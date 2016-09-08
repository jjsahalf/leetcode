package leetcode;

/**
 * Created by yufeijiang on 9/7/16.
 */
public class WiggleSubsequenceSolution {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        int[] dp=new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        int[] nextSign=new int[nums.length];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                if(diff==0){
                    continue;
                }else if(diff>0){
                    diff=1;
                }else if(diff<0){
                    diff=-1;
                }
                if(nextSign[j]==0 && (dp[j]+1)>dp[i]){
                    dp[i]=dp[j]+1;
                    nextSign[i]=diff*(-1);
                }
                if(nextSign[j]!=0 && nextSign[j]==diff && (dp[j]+1)>dp[i]){
                    dp[i]=dp[j]+1;
                    nextSign[i]=diff*(-1);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
