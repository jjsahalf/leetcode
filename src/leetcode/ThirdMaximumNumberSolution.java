package leetcode;

/**
 * Created by yufeijiang on 10/21/16.
 */
public class ThirdMaximumNumberSolution {
    public int thirdMax(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int thirdMax=Integer.MIN_VALUE;
        boolean containsMinValue=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==Integer.MIN_VALUE){
                containsMinValue=true;
            }
            if(nums[i]>max){
                thirdMax=secondMax;
                secondMax=max;
                max=nums[i];
            }else if(nums[i]>secondMax && nums[i]<max){
                thirdMax=secondMax;
                secondMax=nums[i];
            }else if(nums[i]>thirdMax && nums[i]<secondMax){
                thirdMax=nums[i];
            }
        }
        if(thirdMax==secondMax){
            return max;
        }
        if(!containsMinValue && thirdMax==Integer.MIN_VALUE){
            return max;
        }
        return thirdMax;
    }
}
