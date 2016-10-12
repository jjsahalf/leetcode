package leetcode;

/**
 * Created by yufeijiang on 10/12/16.
 */
public class SplitArrayLargestSumSolution {
    public int splitArray(int[] nums, int m) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int left=0;
        int right=0;
        for(int i=0;i<nums.length;i++){
            left=Math.max(left, nums[i]);
            right+=nums[i];
        }
        while(left+1<right){
            int middle=left+(right-left)/2;
            int localSum=0;
            int localM=1;
            if(canSplit(nums, m, middle)){
                right=middle;
            }else{
                left=middle;
            }
        }
        if(canSplit(nums, m, left)){
            return left;
        }else{
            return right;
        }
    }
    public boolean canSplit(int nums[], int m, int middle){
        int localSum=0;
        int localM=1;
        for(int i=0; i<nums.length; i++){
            if(localSum+nums[i]<=middle){
                localSum+=nums[i];
            }else{
                localM++;
                localSum=nums[i];
                if(localM>m){
                    return false;
                }
            }
        }
        return true;
    }
}
