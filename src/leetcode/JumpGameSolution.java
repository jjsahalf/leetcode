package leetcode;

/**
 * Created by yufeijiang on 3/25/16.
 */
public class JumpGameSolution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0){
            return true;
        }
        int end=0;
        int i=0;
        int currentRange=0;
        while(i<=end){
            currentRange=i+nums[i];
            if(currentRange>=nums.length-1){
                return true;
            }else if(currentRange>end){
                end=currentRange;
            }
            i++;
        }
        return false;
    }
}
