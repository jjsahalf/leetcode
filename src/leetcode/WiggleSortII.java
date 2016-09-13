package leetcode;

import java.util.Arrays;

/**
 * Created by yufeijiang on 9/13/16.
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<=0){
            return;
        }
        Arrays.sort(nums);
        int[] wiggle=new int[nums.length];
        int j=nums.length-1;
        for(int i=1;i<wiggle.length;i+=2){
            wiggle[i]=nums[j];
            j--;
        }
        for(int i=0;i<wiggle.length;i+=2){
            wiggle[i]=nums[j];
            j--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=wiggle[i];
        }
    }
}
