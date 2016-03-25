package leetcode;

import java.util.Arrays;

/**
 * Created by yufeijiang on 3/25/16.
 */
public class LengthOfLISSolution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int[] dp=new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int biggest=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>biggest){
                        biggest=dp[j]+1;
                    }
                }
            }
            dp[i]=biggest;
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}
