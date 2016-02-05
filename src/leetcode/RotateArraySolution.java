package leetcode;

/**
 * Created by yufeijiang on 2/4/16.
 */
public class RotateArraySolution {
    public void rotate(int[] nums, int k) {
        if(nums==null){
            return;
        }

        if(nums.length==0){
            return;
        }

        int length=nums.length;
        int[] newNums=new int[length];
        for(int i=0;i<length;i++){
            newNums[i]=nums[i];
        }

        for(int i=0;i<length;i++){
            nums[(i+k)%length]=newNums[i];
        }
    }
}
