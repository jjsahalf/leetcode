package leetcode;

/**
 * Created by yufeijiang on 9/1/16.
 */
public class ProductofArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int[] output=new int[nums.length];
        int left=1;
        for(int i=0;i<nums.length;i++){
            output[i]=left;
            left*=nums[i];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            output[i]*=right;
            right*=nums[i];
        }
        return output;
    }
}
