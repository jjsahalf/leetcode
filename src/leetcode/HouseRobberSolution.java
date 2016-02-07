package leetcode;

/**
 * Created by yufeijiang on 2/6/16.
 */
public class HouseRobberSolution {
    public int rob(int[] nums) {
        if(nums==null){
            return 0;
        }
        if(nums.length==0){
            return 0;
        }
        int length=nums.length;
        int[] dp=new int[length];
        int maxNumber=0;
        if(length>=1){
            dp[0]=nums[0];
        }
        if(length>=2){
            dp[1]=Math.max(nums[0],nums[1]);
        }

        for(int i=2;i<length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[length-1];
    }
}
