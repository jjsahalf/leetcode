package leetcode;

/**
 * Created by yufeijiang on 8/30/16.
 */
public class MinimumSizeSubarraySumSolution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        while(right<=nums.length && left<=right){
            if(sum<s){
                if(right<nums.length){
                    sum+=nums[right];
                }
                right++;
            }else{
                int localLength=right-left;
                res=Math.min(res, localLength);
                sum-=nums[left];
                left++;
            }
        }
        if(res==Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }
}
