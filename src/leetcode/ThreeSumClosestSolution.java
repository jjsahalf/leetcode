package leetcode;

import java.util.Arrays;

/**
 * Created by yufeijiang on 2/20/16.
 */
public class ThreeSumClosestSolution {

    /*
    感觉要遍历两次的问题,多想想两侧的指针一起网中间走,遍历一次与target相比!
     */


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length=nums.length;

        int delta=Integer.MAX_VALUE/2;

        for(int i=0;i<nums.length-2;i++){
            int subTarget=target-nums[i];
            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int currentDelta=nums[left]+nums[right]-subTarget;
                if(currentDelta==0){
                    return target;
                }
                if(Math.abs(currentDelta)<Math.abs(delta)){
                    delta=currentDelta;
                }

                if(currentDelta>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return target+delta;

    }
}
