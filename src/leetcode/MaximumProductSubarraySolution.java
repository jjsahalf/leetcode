package leetcode;

/**
 * Created by yufeijiang on 8/4/16.
 */
public class MaximumProductSubarraySolution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==0){
            return nums[0];
        }
        int localMax=nums[0];
        int localMin=nums[0];
        int globalMax=nums[0];
        for(int i=1; i<nums.length;i++){
            int localMaxCopy=localMax;
            localMax=Math.max(Math.max(localMax*nums[i],localMin*nums[i]), nums[i]);
            localMin=Math.min(Math.min(localMaxCopy*nums[i],localMin*nums[i]), nums[i]);
            globalMax=Math.max(globalMax,localMax);
        }
        return globalMax;
    }
}
