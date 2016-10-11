package leetcode;

/**
 * Created by yufeijiang on 10/11/16.
 */
public class IncreasingTripletSubsequenceSolution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length<=2){
            return false;
        }
        int min=Integer.MAX_VALUE;
        int secondMin=Integer.MAX_VALUE;
        for(int i=0; i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }else if(nums[i]>min && nums[i]<secondMin){
                secondMin=nums[i];
            }else if(nums[i]>secondMin){
                return true;
            }
        }
        return false;
    }
}
